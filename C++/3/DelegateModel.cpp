#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <sstream>
#include <vector>
#include <pthread.h>
#include <chrono>

using namespace std;

vector<string> files;
vector<pair<string, int>> answer;
string word;

struct SThreadParam
{
    int start;
    int amount;
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

void* tFunc(void* parameter)
{
    SThreadParam* p = (SThreadParam*)parameter;

    for (size_t i = p->start; i < p->start + p->amount; i++)
    {
        ifstream fin(files.at(i));
        int count = 0;
        string w;
        if (fin.is_open())
        {
            while (fin)
            {
                fin >> w;
                deletePunctuation(w);
                if (w.compare(word) == 0)
                    count++;
            }

            answer[i] = make_pair(files.at(i), count);
            fin.close();
        }
    }

    return NULL;
}

int main()
{
    int n;
    vector<pthread_t> threads;
    vector<SThreadParam> params;
    string temp, segment;
    int count = 0;
    string fff = "C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\1.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\2.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\3.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\4.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\5.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\6.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\7.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\8.txt";

    cout << "Enter threads amount: ";
    cin >> n;
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

    answer.resize(files.size());
    params.resize(n);

    int filesPerThread = round((float)files.size() / (float)n);

    for (size_t i = 0; i < n; i++)
    {
        pthread_t thread;
        threads.push_back(thread);

        params[i].start = i * filesPerThread;
        if (i != n - 1) 
            params[i].amount = filesPerThread;
        else 
            params[i].amount = (files.size() - (n - 1) * filesPerThread);
    }

    //auto begin = std::chrono::high_resolution_clock::now();

    for (size_t i = 0; i < n; i++)
    {
        pthread_create(&threads.at(i), NULL, tFunc, (void*)&params[i]);
    }

    for (size_t i = 0; i < n; i++)
    {
        pthread_join(threads.at(i), NULL);
    }

    //auto end = std::chrono::high_resolution_clock::now();
    
    //std::cout << "\nExecuted in " << std::chrono::duration_cast<std::chrono::milliseconds>(end - begin).count() << "ms" << std::endl;

    cout << endl << "Result:" << endl;
    for (size_t i = 0; i < answer.size(); i++)
    {
        cout << answer.at(i).first << ": " << answer.at(i).second << endl;
    }
}