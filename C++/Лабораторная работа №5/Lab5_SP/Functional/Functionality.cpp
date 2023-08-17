#include "Functionality.h"
#include <stdio.h>
#include <iostream> 

void Open(char* str)
{
	number_plugins = 0;
	WIN32_FIND_DATA Dll_file;
	HANDLE hDll_file = FindFirstFile("Plugins\\*.dll", &Dll_file);

	if (hDll_file != INVALID_HANDLE_VALUE)
	{
		do
		{
			char mas[256] = "Plugins\\";
			strcat_s(mas, 256, Dll_file.cFileName);
			Plugins[number_plugins] = LoadLibrary(mas);
			++number_plugins;
		} while (FindNextFile(hDll_file, &Dll_file) && number_plugins < 12);

		if (!strcmp(str, "ru"))
			printf("Загружено плагинов: %d \n\n", number_plugins);
		else
			printf("Plugins loaded: %d \n\n", number_plugins);
	}
	FindClose(hDll_file);
}

void Unload(char* str)
{
	if (number_plugins != 0)
	{
		while (number_plugins != 0)
		{
			FreeLibrary(Plugins[number_plugins - 1]);
			Plugins[number_plugins - 1] = NULL;
			--number_plugins;
		} 

		if (!strcmp(str, "ru"))
			printf("%s\n\n", "Все плагины были выгружены");
		else
			printf("%s\n\n", "All plugins were unloaded.");
	}
	else
	{
		if (!strcmp(str, "ru"))
			printf("%s\n\n", "Плагины не были загружены");
		else
			printf("%s\n\n", "There're no loaded plugins");
	}
}
void Info(char* str)
{
	if (number_plugins == 0)
	{
		if (!strcmp(str, "ru"))
			printf("%s\n\n", "Плагины не были загружены");
		else
			printf("%s\n\n", "There're no loaded plugins");
	}
	else
	{
		for (int i = 1; i <= number_plugins; ++i)
		{
			printf("%s%d\n", "Plugin", i);
		}
    }
}
void Information(char* str)
{
	if (number_plugins != 0)
	{
		DWORD pdwBytesWritten = 0;
		char buffer[100];
		_Info information;
		for (int i = 0; i < number_plugins; ++i)
		{
			information = (_Info)GetProcAddress(Plugins[i], "GetDescription");
			information(buffer, 100, &pdwBytesWritten, str);

			if (!strcmp(str, "ru"))
			{
				printf("Плагин%d: %s\n", i + 1, buffer);
			}
			else
			{
				printf("Plugin%d: %s\n", i + 1, buffer);
			}
			information = (_Info)GetProcAddress(Plugins[i], "GetAuthor");
			information(buffer, 100, &pdwBytesWritten, str);
			if (!strcmp(str, "ru"))
			{
				printf("Автор: %s\n", buffer);
			}
			else
			{
				printf("Author: %s\n", buffer);
			}
		}
	}
	else
	{
		if (!strcmp(str, "ru"))
			printf("%s\n\n", "Плагины не были загружены");
		else
			printf("%s\n\n", "There're no loaded plugins");
	}
}

void Execution(char* str)
{
	if(number_plugins != 0)
	{
		Execute_Plugin plugin;
		for (int i = 0; i < number_plugins; ++i)
		{
			plugin = (Execute_Plugin)GetProcAddress(Plugins[i], "Execute");
			plugin(str);
		}
	}
	else
	{
		if (!strcmp(str, "ru"))
			printf("%s\n\n", "Плагины не были загружены");
		else
			printf("%s\n\n", "There're no loaded plugins");
	}
}