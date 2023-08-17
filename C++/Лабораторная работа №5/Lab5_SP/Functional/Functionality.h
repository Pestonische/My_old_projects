#pragma once

#include <stdio.h>
#include <windows.h>

#ifdef __cplusplus

extern "C" 
{
#endif

	typedef void(*Execute_Plugin)(char*);
	typedef bool(*_Info)(LPSTR, DWORD, DWORD*, char*);
	__declspec(dllexport) HINSTANCE Plugins[12];
	__declspec(dllexport) int number_plugins;

	__declspec(dllexport) void Open(char* lang);
	__declspec(dllexport) void Unload(char* lang);
	__declspec(dllexport) void Information(char* lang);
	__declspec(dllexport) void Execution(char* lang);
	__declspec(dllexport) void Info(char* lang);

#ifdef __cplusplus
};
#endif