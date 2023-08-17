#define _CRT_SECURE_NO_WARNINGS
#include "Windows.h"
#include <fstream>
#include <iostream>
#include <queue>
#pragma warning(disable: 4996)

#define threads_num 2
#define intsz sizeof(int)
#define SMALL_SPLITED_FILE_NAME ".tmp"
#define INPUT_FILE "input.txt"
#define OUTPUT_FILE "output.txt"
#define SMALL_FILE_SIZE 20000


struct thread_info {
	int* arr;
	int arrSize;
	int outFile;
	bool exit;
};

struct merge_info {
	bool exit;
	char* outFile;
	int in1File;
	char* in2File;
};

thread_info* threads_info;
merge_info* merges_info;

HANDLE* hThreads;
HANDLE* start_event;
HANDLE* finish_event;
int splited_files_count = 0;


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

DWORD WINAPI sort_and_write_to_small_file(LPVOID data) {
	int i = (int)data;
	while (true) {

		WaitForSingleObject(start_event[i], INFINITE);

		if (!threads_info[i].exit) {


			char name[20];

			//bubble_sort(threads_info[i].arr, threads_info[i].arrSize);
			merge_sort(threads_info[i].arr, threads_info[i].arrSize);

			sprintf(name, "%d%s", threads_info[i].outFile, SMALL_SPLITED_FILE_NAME);

			std::ofstream out(name);
			out << threads_info[i].arrSize << "\n";
			for (int j = 0; j < threads_info[i].arrSize; j++) {
				out << threads_info[i].arr[j] << " ";
			}
			out.close();

			free(threads_info[i].arr);
		}
		else {
			break;
		}

		SetEvent(finish_event[i]);
	}
	return 0;
}

DWORD WINAPI merge_small_files(LPVOID data) {
	int i = (int)data;
	char* name = new char[20];
	while (true) {

		WaitForSingleObject(start_event[i], INFINITE);

		if (!merges_info[i].exit) {
		
			sprintf(name, "%d%s", merges_info[i].in1File, SMALL_SPLITED_FILE_NAME);
			merge_two_files_in_one(name, merges_info[i].in2File, merges_info[i].outFile);

			remove(name);
			remove(merges_info[i].in2File);
			rename(merges_info[i].outFile, merges_info[i].in2File);
		}
		else {
			break;
		}
		SetEvent(finish_event[i]);
	}

	delete name;
	return 0;
}

void split(const char* input) {

	for (int i = 0; i < threads_num; i++) {
		hThreads[i] = CreateThread(NULL, NULL, sort_and_write_to_small_file, (void*)i, NULL, NULL);
	}

	std::ifstream in(INPUT_FILE);
	int array_size;
	in >> array_size;
	int small_file_count = array_size / SMALL_FILE_SIZE;
	int residue = array_size - small_file_count * SMALL_FILE_SIZE;
	if (residue)
		small_file_count += 1;

	for (int i = 0; i < small_file_count; i++) {
		int size = ((i == small_file_count - 1 && residue != 0) ? residue : SMALL_FILE_SIZE);
		int* arr = new int[size];
		int tmp;
		for (int j = 0; j < size; j++) {
			in >> tmp;
			arr[j] = tmp;
		}
		int freeThread = WaitForMultipleObjects(threads_num, finish_event, FALSE, INFINITE) - WAIT_OBJECT_0;
		threads_info[freeThread].arr = arr;
		threads_info[freeThread].arrSize = size;
		threads_info[freeThread].outFile = i;
		threads_info[freeThread].exit = false;
		SetEvent(start_event[freeThread]);
	}
	in.close();
	WaitForMultipleObjects(threads_num, finish_event, TRUE, INFINITE);

	for (int i = 0; i < threads_num; i++) {
		threads_info[i].exit = true;
		SetEvent(start_event[i]);
	}
	splited_files_count = small_file_count;

}

void merge(const char* output) {
	int files_to_merge = splited_files_count;

	char** buf_names = new char* [threads_num];
	char** rez_names = new char* [threads_num];


	for (int i = 0; i < threads_num; i++) {
		hThreads[i] = CreateThread(NULL, NULL, merge_small_files, (void*)i, NULL, NULL);
		buf_names[i] = new char[20];
		rez_names[i] = new char[20];
	}


	for (int i = 0; i < threads_num; i++) {
		sprintf(buf_names[i], "buf%d%s", i, SMALL_SPLITED_FILE_NAME);
		sprintf(rez_names[i], "rez%d%s", i, SMALL_SPLITED_FILE_NAME);
		std::ofstream out(buf_names[i]);
		out << 0;
		out.close();
	}

	for (int i = 0; i < files_to_merge; ++i) {
		int freeThread = WaitForMultipleObjects(threads_num, finish_event, FALSE, INFINITE) - WAIT_OBJECT_0;

		merges_info[freeThread].in1File = i;
		merges_info[freeThread].in2File = buf_names[freeThread];
		merges_info[freeThread].outFile = rez_names[freeThread];
		merges_info[freeThread].exit = false;

		SetEvent(start_event[freeThread]);
	}

	WaitForMultipleObjects(threads_num, finish_event, TRUE, INFINITE);


	for (int i = 0; i < threads_num; i++) {
		merges_info[i].exit = true;
		SetEvent(start_event[i]);
	}
	for (int i = 1; i < threads_num; i++) {
		merge_two_files_in_one(buf_names[i - 1], buf_names[i], rez_names[i]);
		remove(buf_names[i]);
		remove(buf_names[i - 1]);
		rename(rez_names[i], buf_names[i]);
	}
	remove(output);
	rename(buf_names[threads_num - 1], output);

	for (int i = 0; i < threads_num; i++) {
		delete[] buf_names[i];
		delete[] rez_names[i];
	}
}

int main() {
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;

	QueryPerformanceFrequency(&liFrequency);
	QueryPerformanceCounter(&liStartTime);


	threads_info = new thread_info[threads_num];
	merges_info = new merge_info[threads_num];
	start_event = new HANDLE[threads_num];
	finish_event = new HANDLE[threads_num];
	hThreads = new HANDLE[threads_num];

	for (int i = 0; i < threads_num; i++) {
		start_event[i] = CreateEvent(NULL, FALSE, FALSE, NULL);
		finish_event[i] = CreateEvent(NULL, FALSE, TRUE, NULL);
	}

	split(INPUT_FILE);

	WaitForMultipleObjects(threads_num, hThreads, TRUE, INFINITE);
	for (int i = 0; i < threads_num; ++i) {
		CloseHandle(hThreads[i]);
		SetEvent(finish_event[i]);
	}


	merge(OUTPUT_FILE);

	WaitForMultipleObjects(threads_num, hThreads, TRUE, INFINITE);

	for (int i = 0; i < threads_num; ++i) {
		CloseHandle(start_event[i]);
		CloseHandle(finish_event[i]);
		CloseHandle(hThreads[i]);
	}

	QueryPerformanceCounter(&liFinishTime);

	double dElapsedTime = (double(liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart);
	printf("Elapsed time: %lf s.\n", dElapsedTime);




	delete[] hThreads;
	delete[] finish_event;
	delete[] start_event;
	delete[] threads_info;
	delete[] merges_info;

	return 0;
}