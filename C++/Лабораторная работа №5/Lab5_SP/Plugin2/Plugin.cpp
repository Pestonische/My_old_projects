#include "dll.h"
#include <stdio.h>

BOOLEAN GetAuthor(LPSTR buffer, DWORD dwBufferSize, DWORD* pdwBytesWritten, char* str)
{
	int object;
	if (!strcmp(str, "ru"))
		object = _snprintf_s(buffer, dwBufferSize, 30, "Козунов Алексей 13 группа");
	else
		object = _snprintf_s(buffer, dwBufferSize, 30, "Kozunov Alexei 13 group");

	*pdwBytesWritten = object;
	return object;
}

BOOLEAN GetDescription(LPSTR buffer, DWORD dwBufferSize, DWORD* pdwBytesWritten, char* str)
{
	int object;
	if (!strcmp(str, "ru"))
		object = _snprintf_s(buffer, dwBufferSize, 28, "Вывод системной информации");
	else
		object = _snprintf_s(buffer, dwBufferSize, 28, "Output of system information");
	*pdwBytesWritten = object;
	return object;
}

VOID Execute(char*)
{
	system("msinfo32");
	printf("\n");
}