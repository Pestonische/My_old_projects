#include <iostream>
#include <windows.h>
#include <process.h>
#include <stdio.h>
#include <fstream>

#define n 500000
#define AMOUNTS 1
#define INPUT_FILE "input.txt"
using namespace std;

void merge_sort(int* a, int size);
void merge_sort_recursive(int* a, int left, int right);
void merge_sort_delegate(int* a, int size);
void merge_sort_suplier_consumer(int* a, int size);

void merge(int* a, int left, int mid, int right);
int* random_array(int size);
void output_array(int* array, int size);

bool thread1 = false,
		thread2 = false;

struct arg* args;

struct arg {

	arg() {
		array1 = 0;
		left = 0;
		right = 0;
		middle;
	}

	arg(int* a, int lef, int righ) {
		array1 = a;
		left = lef;
		right = righ;
		middle = 0;
	}


	int* array1;
	int left;
	int middle;
	int right;
};

BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);

int main() {
	int* array;

	array = random_array(n);
	std::ofstream out(INPUT_FILE);

	out << n << "\n";
	for (int j = 0; j < n; j++)
		out << array[j] << " ";
	out.close();

	delete[] array;
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

void merge_sort_recursive(int* a, int left, int right) {
	if (left + 1 >= right) return;

	int mid = (left + right) / 2;
	merge_sort_recursive(a, left, mid);
	merge_sort_recursive(a, mid, right);
	merge(a, left, mid, right);
}

void merge_sort(int* a, int size) {

	for (int i = 1; i < size; i *= 2) {

		for (int j = 0; j < size - i; j += 2 * i) {
			merge(a, j, j + i, min(j + 2 * i, size));
		}
	}
}

unsigned WINAPI ThreadFunction1(LPVOID pvParam)
{
	int param = (int)pvParam;
	//cout << args[param].array1 << " " << args[param].left << " " << args[param].right;

	merge_sort_recursive(args[param].array1, args[param].left, args[param].right);
	return 0;

}

unsigned WINAPI ThreadFunction2(LPVOID pvParam)
{
	int param = (int)pvParam;
	if (param == 0) {
		while(!thread1){}
		merge_sort_recursive(args[param].array1, args[param].left, args[param].right);
	}

	if (param == 1) {
		while (!thread2) {}
		merge_sort_recursive(args[param].array1, args[param].left, args[param].right);

	}

	return 0;

}

void merge_sort_delegate(int* a, int size) {
	int thread_amounts = 2;

	HANDLE* hThreads = new HANDLE[thread_amounts];
	args = new struct arg[thread_amounts];

	int middle = size / 2;

	args[0] = arg(a, 0, middle);
	args[1] = arg(a, middle, size);

	
	hThreads[0] = (HANDLE)_beginthreadex(NULL, 0, ThreadFunction1, (LPVOID)0, 0, NULL);
	hThreads[1] = (HANDLE)_beginthreadex(NULL, 0, ThreadFunction1, (LPVOID)1, 0, NULL);

	WaitForMultipleObjects(thread_amounts, hThreads, TRUE, INFINITE);

	merge(a, 0, middle, size);

	delete[] hThreads;
	delete[] args;
}

void merge_sort_suplier_consumer(int* a, int size) {
	int thread_amounts = 2;

	HANDLE* hThreads = new HANDLE[thread_amounts];
	args = new struct arg[thread_amounts];

	int middle = size / 2;

	args[0] = arg(a, 0, middle);
	args[1] = arg(a, middle, size);


	hThreads[0] = (HANDLE)_beginthreadex(NULL, 0, ThreadFunction2, (LPVOID)0, 0, NULL);
	hThreads[1] = (HANDLE)_beginthreadex(NULL, 0, ThreadFunction2, (LPVOID)1, 0, NULL);

	thread1 = true;
	thread2 = true;

	WaitForMultipleObjects(thread_amounts, hThreads, TRUE, INFINITE);

	merge(a, 0, middle, size);

	delete[] hThreads;
	delete[] args;
}

int* random_array(int size) {
	int* a = new int[size];

	for (int i = 0; i < size; i++) {
		a[i] = rand() % 1000;
	}

	return a;
}

void output_array(int* array, int size) {
	for (int i = 0; i < size; i++) {
		cout << array[i] << " ";
	}
	cout << endl;
}