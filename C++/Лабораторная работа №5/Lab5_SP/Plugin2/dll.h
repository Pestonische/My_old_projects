#include <windows.h>

#ifdef __cplusplus

extern "C"
{
#endif

	__declspec(dllexport) BOOLEAN GetAuthor(LPSTR buffer, DWORD dwBufferSize, DWORD* pdwBytesWritten, char*);
	__declspec(dllexport) BOOLEAN GetDescription(LPSTR buffer, DWORD dwBufferSize, DWORD* pdwBytesWritten, char*);
	__declspec(dllexport) VOID Execute(char*);

#ifdef __cplusplus
};
#endif