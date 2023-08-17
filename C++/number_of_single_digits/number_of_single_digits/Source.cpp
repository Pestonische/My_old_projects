#include <iostream>
using namespace std;

int number_of_discharges(int value) {
	_asm {
		mov eax, value
		mov ebx, 1
		mov ecx, 0
		l1:
		test eax, ebx
			jz not_1
			inc ecx
		not_1 :
		shl ebx, 1
			cmp ebx, 0
			je finish
			jmp l1
			finish :
		mov eax, ecx
	}
}

int main() {
	setlocale(LC_ALL, "rus");
	int number;
	cout << "Введите число: " << endl;
	cin >> number;
	cout << "Ответ: " << number_of_discharges(number);
}