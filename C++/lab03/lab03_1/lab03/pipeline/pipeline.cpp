
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <fstream>
#include "Windows.h"
#include <algorithm> 
#pragma warning(disable: 4996)

#define intsz sizeof(int)
#define SMALL_SPLITED_FILE_NAME ".temp"
#define INPUT_FILE "input.txt"
#define OUTPUT_FILE "output.txt"
#define SMALL_FILE_SIZE 30000

CRITICAL_SECTION cs_queue;
HANDLE semaphore;
HANDLE finish_event;
std::queue<int> buffer;

void buffer_file(int i) {
	EnterCriticalSection(&cs_queue);
	buffer.push(i);
	LeaveCriticalSection(&cs_queue);
	ReleaseSemaphore(semaphore, 1, NULL);
}

int unbuffer_file() {
	EnterCriticalSection(&cs_queue);
	int result = buffer.front();
	buffer.pop();
	LeaveCriticalSection(&cs_queue);
	return result;
}

bool is_buffer_empty() {
	EnterCriticalSection(&cs_queue);
	bool result = buffer.empty() && WaitForSingleObject(finish_event, 0) == WAIT_OBJECT_0;
	LeaveCriticalSection(&cs_queue);
	return result;
}

void bubble_sort(int* arr, int n) {
	for (int i = 0; i < n - 1; i++)
		for (int j = 0; j < n - i - 1; j++)
			if (arr[j] > arr[j + 1])
				std::swap(arr[j], arr[j + 1]);
}


void merge(int* a, int left, int mid, int right) {

	int it1 = 0;
	int it2 = 0;
	int* result = new int[right - left];

	while (left + it1 < mid && mid + it2 < right) {
		if (a[left + it1] < a[mid + it2]) {

			result[it1 + it2] = a[left + it1];
			it1 += 1;
		}
		else {
			result[it1 + it2] = a[mid + it2];
			it2 += 1;
		}
	}

	while (left + it1 < mid) {
		result[it1 + it2] = a[left + it1];
		it1 += 1;
	}

	while (mid + it2 < right) {
		result[it1 + it2] = a[mid + it2];
		it2 += 1;
	}

	for (int i = 0; i < it1 + it2; i++) {
		a[left + i] = result[i];
	}

	delete[] result;
}

void merge_sort(int* a, int size) {

	for (int i = 1; i < size; i *= 2) {

		for (int j = 0; j < size - i; j += 2 * i) {
			merge(a, j, j + i, min(j + 2 * i, size));
		}
	}
}




void merge_two_files_in_one(char* name1, char* name2, char* nameout) {
	std::fstream in1(name1);
	std::fstream in2(name2);
	std::ofstream out(nameout);
	int file1_size, file2_size;
	int number1, number2;
	in1 >> file1_size;
	in2 >> file2_size;
	in1 >> number1;
	in2 >> number2;
	int count = file1_size + file2_size;
	out << count << "\n";
	int peek1 = file1_size;
	int peek2 = file2_size;
	for (int i = 0; i < count; ++i) {
		if (!peek1) {
			out << number2 << " ";
			in2 >> number2;
			continue;
		}
		if (!peek2) {
			out << number1 << " ";
			in1 >> number1;
			continue;
		}
		if (number1 > number2) {
			out << number2 << " ";
			in2 >> number2;
			peek2--;
		}
		else {
			out << number1 << " ";
			in1 >> number1;
			peek1--;
		}
	}
	in1.close();
	in2.close();
	out.close();
}

DWORD WINAPI split(LPVOID data) {
	char* input = (char*)data;
	std::ifstream fin(input);

	char* name = new char[20];
	int number;
	int big_file_size = 0;
	fin >> big_file_size;

	int small_file_count = big_file_size / SMALL_FILE_SIZE;
	int residue = big_file_size - small_file_count * SMALL_FILE_SIZE;
	if (residue)
		small_file_count += 1;

	for (int i = 0; i < small_file_count; ++i) {
		sprintf(name, "%d%s", i, SMALL_SPLITED_FILE_NAME);
		int size = ((i == small_file_count - 1 && residue != 0) ? residue : SMALL_FILE_SIZE);
		int* arr = new int[size];

		for (int i = 0; i < size; ++i) {
			fin >> number;
			arr[i] = number;
		}

		std::ofstream out(name);
		out << size << "\n";
		//bubble_sort(arr, size);
		merge_sort(arr, size);

		for (int j = 0; j < size; j++)
			out << arr[j] << " ";

		out.close();
		buffer_file(i);
	}

	SetEvent(finish_event);
	delete name;
	return 0;
}

DWORD WINAPI merge(LPVOID data) {
	char* output = (char*)data;
	char* name1 = new char[20];
	char* buf_name = new char[20];
	char* rez_name = new char[20];

	sprintf(rez_name, "rez.tmp");
	sprintf(buf_name, "buf.tmp");

	std::ofstream out(buf_name);
	out << 0;
	out.close();

	int file1;

	while (!is_buffer_empty()) {
		WaitForSingleObject(semaphore, INFINITE);
		file1 = unbuffer_file();
		sprintf(name1, "%d%s", file1, SMALL_SPLITED_FILE_NAME);
		merge_two_files_in_one(name1, buf_name, rez_name);
		remove(name1);
		remove(buf_name);
		rename(rez_name, buf_name);
	}

	remove(output);
	rename(buf_name, output);

	delete name1;
	delete buf_name;
	delete rez_name;

	return 0;
}

int main() {
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	InitializeCriticalSection(&cs_queue);
	semaphore = CreateSemaphore(NULL, 0, 1000000, NULL);

	QueryPerformanceFrequency(&liFrequency);
	QueryPerformanceCounter(&liStartTime);

	finish_event = CreateEvent(NULL, FALSE, FALSE, NULL);

	HANDLE sortThread = CreateThread(NULL, 0, split, (void*)INPUT_FILE, NULL, NULL);
	HANDLE mergeThread = CreateThread(NULL, 0, merge, (void*)OUTPUT_FILE, NULL, NULL);

	WaitForSingleObject(sortThread, INFINITE);
	WaitForSingleObject(mergeThread, INFINITE);

	QueryPerformanceCounter(&liFinishTime);

	double dElapsedTime = (double(liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart);
	printf("Elapsed time: %lf s.\n", dElapsedTime);

	CloseHandle(finish_event);
	CloseHandle(sortThread);
	CloseHandle(mergeThread);
	CloseHandle(semaphore);
	DeleteCriticalSection(&cs_queue);

	return 0;
}