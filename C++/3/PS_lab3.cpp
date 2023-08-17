//#include <iostream>
//#include <fstream>
//#include <string>
//#include <vector>
//#include <chrono>
//#include <sstream>
//
//using namespace std;
//
//
//void withoutPunctuation(string& str)
//{
//    if (str.size() > 1)
//    {
//        bool check = str[0] == ' ' || str[0] == '.' || str[0] == ',' || str[0] == ';' || str[0] == ':' || str[0] == '-' || str[0] == '!' || str[0] == '?' || str[0] == '/' || str[0] == '(' || str[0] == ')';
//
//        while (check)
//        {
//            str = str.substr(1);
//        }
//
//        int end_element = str.size() - 1;
//
//        if (end_element > 0)
//        {
//            while (check)
//            {
//                str = str.substr(0, end_element);
//                end_element--;
//            }
//        }
//    }
//}
//
//int main()
//{
//    string word, words;
//    vector<string> files;
//    vector<pair<string, int>> answer;
//    string temp, segment;
//    int count = 0;
//    string fff = "C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\1.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\2.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\3.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\4.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\5.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\6.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\7.txt;C:\\Users\\alexe\\Desktop\\Laba 1 Rips\\3\\8.txt";
//
//    cout << "Enter a word: ";
//    cin >> word;
//    //cout << "Enter files: ";
//    //cin >> temp;
//    //stringstream ss(temp);
//    stringstream ss(fff);
//
//    while (getline(ss, segment, ';'))
//    {
//        files.push_back(segment);
//    }
//
//    auto begin = std::chrono::high_resolution_clock::now();
//
//    for (size_t i = 0; i < files.size(); i++)
//    {
//        ifstream fin(files.at(i));
//        count = 0;
//        if (fin.is_open())
//        {
//            while (fin)
//            {
//                fin >> words;
//                withoutPunctuation(words);
//                if (words.compare(word) == 0)
//                    count++;
//            }
//
//            answer.push_back(make_pair(files.at(i), count));
//            fin.close();
//        }
//    }
//
//    auto end = std::chrono::high_resolution_clock::now();
//
//    std::cout << "\nExecuted in " << std::chrono::duration_cast<std::chrono::milliseconds>(end - begin).count() << "ms" << std::endl;
//
//    cout << endl << "Result:" << endl;
//
//    for (size_t i = 0; i < answer.size(); i++)
//    {
//        cout << answer.at(i).first << ": " << answer.at(i).second << endl;
//    }
//}
#include <stdio.h>
#include <stdlib.h>
#define SIZE 10

// Функция быстрой сортировки
void quickSort(int* numbers, int left, int right)
{
    int pivot; // разрешающий элемент
    int l_hold = left; //левая граница
    int r_hold = right; // правая граница
    pivot = numbers[left];
    while (left < right) // пока границы не сомкнутся
    {
        while ((numbers[right] >= pivot) && (left < right))
            right--; // сдвигаем правую границу пока элемент [right] больше [pivot]
        if (left != right) // если границы не сомкнулись
        {
            numbers[left] = numbers[right]; // перемещаем элемент [right] на место разрешающего
            left++; // сдвигаем левую границу вправо
        }
        while ((numbers[left] <= pivot) && (left < right))
            left++; // сдвигаем левую границу пока элемент [left] меньше [pivot]
        if (left != right) // если границы не сомкнулись
        {
            numbers[right] = numbers[left]; // перемещаем элемент [left] на место [right]
            right--; // сдвигаем правую границу влево
        }
    }
    numbers[left] = pivot; // ставим разрешающий элемент на место
    for (int i = 0; i < SIZE; i++)
        printf("%4d ", numbers[i]);
    printf("\n");
    pivot = left;
    left = l_hold;
    right = r_hold;
    if (left < pivot) // Рекурсивно вызываем сортировку для левой и правой части массива
        quickSort(numbers, left, pivot - 1);
    if (right > pivot)
        quickSort(numbers, pivot + 1, right);
}
int main()
{
    int a[SIZE];
    // Заполнение массива случайными числами
    for (int i = 0; i < SIZE; i++)
        a[i] = rand() % 201 - 100;
    // Вывод элементов массива до сортировки
    for (int i = 0; i < SIZE; i++)
        printf("%4d ", a[i]);
    printf("\n");
    quickSort(a, 0, SIZE - 1); // вызов функции сортировки
              // Вывод элементов массива после сортировки
    for (int i = 0; i < SIZE; i++)
        printf("%4d ", a[i]);
    printf("\n");
    getchar();
    return 0;
}