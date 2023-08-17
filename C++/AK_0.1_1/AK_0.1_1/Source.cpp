#include "mpi.h"
#include <iostream>
#include "Process.h"
#include <ctime>
#include <math.h>

class Program
{
public:
	static void Main()
	{
		MPI::Process process = MPI::Process();
		
		float* data1 = nullptr;
		float* data2 = nullptr;
		float* answer = nullptr;

		
		int count = process.GetProcessCount();
		auto dataLength = 3;

		if (process.IsMaster())
		{
			data1 = new float[dataLength];
			data2 = new float[dataLength];
			answer = new float[count];
			
			Fill(data1, dataLength);
			std::cout << "First vector:  ";
			for (int i = 0; i < dataLength; i++)
			{
				printf("%.3f  ", data1[i]);
			}
			std::cout << std::endl;

			Fill(data2, dataLength);
			std::cout << "Second vector: ";
			for (int i = 0; i < dataLength; i++)
			{
				printf("%.3f  ", data2[i]);
			}
			std::cout << std::endl;
		}
			
		int* sendcounts = new int[count];
		int* displs = new int[count];
		
		int after = dataLength;
		int MAX_PROCESSES = (after / (count)) + 1;
		for (auto i = 0; i < count; i++)
		{
			if (after % (count - i) != 0)
			{
				sendcounts[i] = (after / (count - i)) + 1;
				after -= (after / (count - i)) + 1;
			}
			else
			{
				sendcounts[i] = (after / (count - i));
				after -= (after / (count - i));
			}
			if (i != 0)
				displs[i] = displs[i - 1] + sendcounts[i - 1];
			else
				displs[i] = 0;
		}

		const int MAX_SIZE_SLICE = (dataLength + count - 1) / count;
		float* slice1 = new float[MAX_SIZE_SLICE];
		float* slice2 = new float[MAX_SIZE_SLICE];
		for (int i = 0; i < MAX_SIZE_SLICE; i++)
		{
			slice2[i] = 0;
			slice1[i] = 0;
		}

		MPI_Scatterv(data1, sendcounts, displs, MPI_INT, slice1, sendcounts[process.GetRank()], MPI_INT, 0, MPI_COMM_WORLD);
		MPI_Scatterv(data2, sendcounts, displs, MPI_INT, slice2, sendcounts[process.GetRank()], MPI_INT, 0, MPI_COMM_WORLD);

		float sum = 0;

		for (int i = 0; i < sendcounts[process.GetRank()]; i++)
		{
			sum += slice1[i] * slice2[i];
		}

		Gather(sum, answer);
		
		if (process.IsMaster())
		{
			float _answer = 0;
			for (int i = 0; i < count; i++)
			{
				if(answer)
				_answer += answer[i];
			}

			printf("Result = %.3f  ", _answer);

			delete[] data1;
			delete[] data2;
			delete[] answer;
		}

		delete[] slice1;
		delete[] slice2;
		delete[] displs;
		delete[] sendcounts;
			
	}

private:
	static void Fill(float* data, int length)
	{
		srand((unsigned int)time(0));
		for (int i = 0; i < length; ++i)
		{
		   data[i]= (float)(rand()) / RAND_MAX * 2 + (-1);
		}
	}

	static void Gather(float sum, float* answer)
	{
		MPI_Gather(&sum, 1, MPI_INT, answer, 1,	MPI_INT, MPI::MasterRank, MPI_COMM_WORLD);
	}	
};

int main()
{
	setlocale(LC_ALL, "rus");
	Program::Main();
	return 0;
}
//cd C:\My project\AK_0.1_1\Debug
//mpiexec -n 4 AK_0.1_1.exe
