#include <cmath>
#include <string.h>
#include <iostream>

double Sin(double x, int k)
{
	int ten = 10;
	_asm
	{
		fld ten
		fld1;
		mov eax, k
	    mov ebx, 0
		While:
		fdiv st, st(1)
			dec eax
			cmp eax, ebx
			jne While

		preparation :
		fstp st
			; e 4
			fld x;  x 3
			fld1;  sum 2
			fld1; знаменатель 1
			fld1; шаг 0
			fld st; сдиг нумерации
			fabs
			; jmp Сalculate

		Сalculate :
		fcomip st, st(5); 
			jna finish
			fld1; 
			faddp st(2), st; сложение
			fdiv st, st(1); деление
			fld1; 
			faddp st(2), st; сложение
			fdiv st, st(1); деление
			fchs
			fmul st, st(3)
			fmul st, st(3)
			fadd st(2), st
			fld st
			fabs
			jmp Сalculate

			finish :
		    fstp st
			fstp st
			fstp st(2)
			fstp st



	}
}
double Sin_2(double x)
{
	_asm
	{
		fld x
		fsin
		fld x
		fdiv st(1), st
		fstp st
	}
}

int main(int args, char* argv[])
{
	setlocale(LC_ALL, "rus");
	if (args != 3)
	{
		std::cout << "Аргументов должно быть 3!";
		exit(-1);
	}
	double x = strtod(argv[1], NULL);
	int k = atoi(argv[2]);
	if (k <= 1)
	{
		std::cout << "Количество знаков после запятой должно быть больше 1!";
		exit(-1);
	}
	std::cout.precision(k);
	std::cout << "Sin(x)/x вывод стандартной функции в с++:        \t" << sin(x) / x << std::endl;
	std::cout << "Sin(x)/x вывод стандартной функции в ассемблере: \t" << Sin_2(x) << std::endl;
	std::cout << "Sin(x)/x вывод ряда тейлора:                     \t" << Sin(x, k) << std::endl;
	return 0;
}