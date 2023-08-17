#include <Windows.h>
#include <process.h>
#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <sstream>
#include <vector>
#include <deque>
#include <pthread.h>
#include <chrono>

using namespace std;

int FilesCount;
vector<string> files;
vector<pair<string, int>> answer;
deque<pair<string, string>> storage;
deque<int> aaa;
CRITICAL_SECTION CriticalSection;

struct ConsumerParam
{
    string word;
};

struct ProducerParam
{
    vector<string> filepathes;
};

void deletePunctuation(string& str)
{
    if (str.size() > 1)
    {
        while (str[0] == ' ' || str[0] == '.' || str[0] == ',' || str[0] == ';' || str[0] == ':' || str[0] == '-' || str[0] == '!' || str[0] == '?' || str[0] == '/' || str[0] == '(' || str[0] == ')')
        {
            str = str.substr(1);
        }

        int last = str.size() - 1;

        if (last > 0)
        {
            while (str[last] == ' ' || str[last] == '.' || str[last] == ',' || str[last] == ';' || str[last] == ':' || str[last] == '-' || str[last] == '!' || str[last] == '?' || str[last] == '/' || str[0] == '(' || str[0] == ')')
            {
                str = str.substr(0, last);
                last--;
            }
        }
    }
}

void* producer(void* parameter)
{
    ProducerParam* p = (ProducerParam*)parameter;

    for (size_t i = 0; i < p->filepathes.size(); i++)
    {
        auto ss = ostringstream{};
        ifstream input_file(p->filepathes[i]);
        if (input_file.is_open())
        {
            ss << input_file.rdbuf();
            storage.push_back(make_pair(ss.str(), p->filepathes[i]));
        }
        else 
        {
            FilesCount--;
        }
    }

    return NULL;
}

void* consumer(void* parameter)
{
    ConsumerParam* p = (ConsumerParam*)parameter;
    string w;
    int count = 0;
    int c = 0;

    while (c != FilesCount)
    {
        //EnterCriticalSection(&CriticalSection);
        if (storage.size() > 0)
        {
            string txt = storage.front().first; // текст файла
            string file = storage.front().second; // название файла
            storage.pop_front();
            //LeaveCriticalSection(&CriticalSection);
            count = 0;
            istringstream stream;
            stream.str(txt);

            while (stream >> w)
            {
                deletePunctuation(w);
                if (w.compare(p->word) == 0)
                    count++;
            }

            answer.push_back(make_pair(file, count));
            c++;
        }
        else 
        {
            //LeaveCriticalSection(&CriticalSection);
        }
    }

    return NULL;
}

int main()
{
    /*aaa.push_back(1); //front
    aaa.push_back(2);
    aaa.push_back(3);
    aaa.push_back(4); //back
    aaa.pop_front();
    cout << aaa.front() << endl;
    cout << aaa.back() << endl;

    return 0;*/
    if (!InitializeCriticalSectionAndSpinCount(&CriticalSection, 0x00000400))
        return 1;

    vector<pthread_t> threads;
    string temp, segment, word;
    int count = 0;
    string fff = "C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\1.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\2.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\3.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\4.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\5.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\6.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\7.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\8.txt";

    cout << "Enter a word: ";
    cin >> word;
    //cout << "Enter files: ";
    //cin >> temp;
    //stringstream ss(temp);
    stringstream ss(fff);

    while (getline(ss, segment, ';'))
    {
        files.push_back(segment);
    }

    FilesCount = files.size();

    //auto begin = std::chrono::high_resolution_clock::now();

    pthread_t threadP;
    pthread_t threadC;

    ProducerParam paramP;
    paramP.filepathes = files;
    ConsumerParam paramC;
    paramC.word = word;

    pthread_create(&threadP, NULL, producer, (void*)&paramP);
    pthread_create(&threadC, NULL, consumer, (void*)&paramC);

    pthread_join(threadP, NULL);
    pthread_join(threadC, NULL);

    auto end = std::chrono::high_resolution_clock::now();

    //std::cout << "\nExecuted in " << std::chrono::duration_cast<std::chrono::milliseconds>(end - begin).count() << "ms" << std::endl;

    //cout << endl << "Result:" << endl;
    for (size_t i = 0; i < answer.size(); i++)
    {
        cout << answer.at(i).first << ": " << answer.at(i).second << endl;
    }

    DeleteCriticalSection(&CriticalSection);
}