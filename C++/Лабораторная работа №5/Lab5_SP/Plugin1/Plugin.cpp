#include "dll.h"
#include <stdio.h>

BOOLEAN GetAuthor(LPSTR buffer, DWORD dwBufferSize, DWORD *pdwBytesWritten, char* str) 
{
	int object;
	if (!strcmp(str, "ru"))
	{
		object = _snprintf_s(buffer, dwBufferSize, 30, "Козунов Алексей 13 группа");
	}
	else
	{
		object = _snprintf_s(buffer, dwBufferSize, 30, "Kozunov Alexei 13 group");
	}
	*pdwBytesWritten = object;
	return object;
}

BOOLEAN GetDescription(LPSTR buffer, DWORD dwBufferSize, DWORD *pdwBytesWritten, char* str)
{
	int object;
	if (!strcmp(str, "ru"))
	{
		object = _snprintf_s(buffer, dwBufferSize, 28, "Вывод системной информации");
	}
	else
	{
		object = _snprintf_s(buffer, dwBufferSize, 28, "Output of system information");
	}
	*pdwBytesWritten = object;
	return object;
}

VOID Execute(char* str)
{
	SYSTEM_INFO system_info;

	GetSystemInfo(&system_info);

	if (!strcmp(str, "ru"))
	{
		printf("  Cистемная информация: \n");
		printf("  dwOemId (устаревший элемент, исключенный для совместимости с Windows NT и более ранними версиями): %u\n", system_info.dwOemId);
		printf("  Число логических процессоров в системе: %u\n",  system_info.dwNumberOfProcessors);
		printf("  Размер страницы и степень детализации защиты и обязательств страницы: %u\n", system_info.dwPageSize);
		printf("  dwProcessorType (устаревший элемент, исключенный для совместимости с Windows NT и более ранними версиями): %u\n", system_info.dwProcessorType);
		printf("  Указатель на самый низкий адрес памяти, доступный приложениям и dll: %p\n", system_info.lpMinimumApplicationAddress);
		printf("  Указатель на самый высокий адрес памяти, доступный приложениям и dll: %p\n", system_info.lpMaximumApplicationAddress);
		printf("  dwActiveProcessorMask (активная маска процессора): %u\n", system_info.dwActiveProcessorMask);
		printf("  wReserved (зарезервировано на будущее): %u\n", system_info.wReserved);
		printf("  dwAllocationGranularity (гранулярность для начального адреса, в котором может быть выделена виртуальная память): %u\n", system_info.dwAllocationGranularity);
		printf("  wProcessorLevel (уровень архитектурно-зависимого процессора системы): %u\n", system_info.wProcessorLevel);
	}
	else
	{
		printf("  System information: \n");
		printf("  dwOemId (Deprecated member that is left out for compatibility with Windows NT and earlier): %u\n", system_info.dwOemId);
		printf("  Number logical of processors in the system: %u\n", system_info.dwNumberOfProcessors);
		printf("  Page size and granularity of page protection and commitment: %u\n", system_info.dwPageSize);
		printf("  dwProcessorType (Deprecated member that is left out for compatibility with Windows NT and earlier): %u\n", system_info.dwProcessorType);
		printf("  Pointer to the lowest memory address available to applications and dll: %p\n", system_info.lpMinimumApplicationAddress);
		printf("  Pointer to the highest memory address available to applications and dll: %p\n", system_info.lpMaximumApplicationAddress);
		printf("  Active processor mask: %u\n", system_info.dwActiveProcessorMask);
		printf("  wReserved (Reserved for the future): %u\n", system_info.wReserved);
		printf("  dwAllocationGranularity (Granularity for the starting address where virtual memory can be allocated): %u\n", system_info.dwAllocationGranularity);
		printf("  wProcessorLevel (The level of the system's architecture-dependent processor): %u\n", system_info.wProcessorLevel);
	}
}