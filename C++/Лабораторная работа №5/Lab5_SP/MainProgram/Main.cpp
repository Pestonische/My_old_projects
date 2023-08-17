#include <stdio.h>
#include <iostream> 
#include <windows.h>
#pragma warning(disable : 4996)
#include "..\Functional\Functionality.h"//неявное подключение 
#pragma comment (lib, "functional.lib")


int main()
{
	setlocale(LC_ALL, "rus");
	printf("%s\n", "Выберите язык:");
	printf("%s\n", "ru - русский");
	printf("%s\n", "en - english");
	char* str = (char*)malloc(20);
	while (true)
	{
		gets_s(str, 20);
		if (!strcmp(str, "ru") || !strcmp(str, "en"))
		{
			break;
		}
	}
	int number = 0;
	while (true)
	{
		if (!strcmp(str, "ru"))
		{
			printf("%s\n", "********Меню********");
			printf("%s\n", "1 - Загрузить плагины");
			printf("%s\n", "2 - Выгрузить плагины");
			printf("%s\n", "3 - Показать на экране список плагинов. (просто имена модулей).");
			printf("%s\n", "4 - Показать информацию о загруженных плагинах");
			printf("%s\n", "5 - Выполнить плагины");
			printf("%s\n", "6 - Очистить консоль");
			printf("%s\n", "7 - Выход");
			printf("%s\n", "********************");
		}
		else
		{
			printf("%s\n", "********Menu********");
			printf("%s\n", "1 - Load plugins");
			printf("%s\n", "2 - Unload plugins");
			printf("%s\n", "3 - Show a list of plugins on the screen. (just module names).");
			printf("%s\n", "4 - Show info about loaded plugins");
			printf("%s\n", "5 - Execute plugins");
			printf("%s\n", "6 - Clean console");
			printf("%s\n", "7 - Exit");
			printf("%s\n", "********************");
		}
		if (scanf("%d", &number) == 1)
		{
			if (number == 1)
			{
				Open(str);
			}
			else if (number == 2)
			{
				Unload(str);
			}
			else if (number == 3)
			{
				Info(str);
			}
			else if (number == 4)
			{
				Information(str);
			}
			else if (number == 5)
			{
				Execution(str);
			}
			else if (number == 6)
			{
				system("cls");
			}
			else if (number == 7)
			{
				Unload(str);
				break;
			}
		}
		else
		{
			if (!strcmp(str, "ru"))
			{
				printf("%s\n", "Неверные данные");
			}
			else
			{
				printf("%s\n", "Invalid data");
			}
		}
	}
	if (!strcmp(str, "ru"))
	{
		printf("%s\n", "Программа завершена");
	}
	else
	{
		printf("%s\n", "Program finished");
	}
	system("pause");
	return 0;
}