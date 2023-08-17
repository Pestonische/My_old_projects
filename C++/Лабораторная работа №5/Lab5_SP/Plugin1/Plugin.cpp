#include "dll.h"
#include <stdio.h>

BOOLEAN GetAuthor(LPSTR buffer, DWORD dwBufferSize, DWORD *pdwBytesWritten, char* str) 
{
	int object;
	if (!strcmp(str, "ru"))
	{
		object = _snprintf_s(buffer, dwBufferSize, 30, "������� ������� 13 ������");
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
		object = _snprintf_s(buffer, dwBufferSize, 28, "����� ��������� ����������");
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
		printf("  C�������� ����������: \n");
		printf("  dwOemId (���������� �������, ����������� ��� ������������� � Windows NT � ����� ������� ��������): %u\n", system_info.dwOemId);
		printf("  ����� ���������� ����������� � �������: %u\n",  system_info.dwNumberOfProcessors);
		printf("  ������ �������� � ������� ����������� ������ � ������������ ��������: %u\n", system_info.dwPageSize);
		printf("  dwProcessorType (���������� �������, ����������� ��� ������������� � Windows NT � ����� ������� ��������): %u\n", system_info.dwProcessorType);
		printf("  ��������� �� ����� ������ ����� ������, ��������� ����������� � dll: %p\n", system_info.lpMinimumApplicationAddress);
		printf("  ��������� �� ����� ������� ����� ������, ��������� ����������� � dll: %p\n", system_info.lpMaximumApplicationAddress);
		printf("  dwActiveProcessorMask (�������� ����� ����������): %u\n", system_info.dwActiveProcessorMask);
		printf("  wReserved (��������������� �� �������): %u\n", system_info.wReserved);
		printf("  dwAllocationGranularity (������������� ��� ���������� ������, � ������� ����� ���� �������� ����������� ������): %u\n", system_info.dwAllocationGranularity);
		printf("  wProcessorLevel (������� ������������-���������� ���������� �������): %u\n", system_info.wProcessorLevel);
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