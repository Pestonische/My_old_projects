import time
import matplotlib.pyplot as plt
from scipy import integrate
import numpy as np


def fun(_x):
    return 1 + np.exp(-_x ** 2) * np.sin(7 * _x)


def a0(x):
    return (x - 2) * (x + 1) * (x) * (x - 1) / ((-2 - 2) * (-2 + 1) * (-2) * (-2 - 1))


def a1(x):
    return (x + 2) * (x - 1) * (x) * (x - 2) / ((-1 + 2) * (-1 - 1) * (-1) * (-1 - 2))


def a2(x):
    return (x + 2) * (x + 1) * (x - 2) * (x - 1) / ((2) * (1) * (-2) * (-1))


def searchA(masX):
    masA = [0 for i in range(len(masX))]
    masA[0], err = masA[4], err = integrate.quad(a0, -2, 2)
    masA[1], err = masA[3], err = integrate.quad(a1, -2, 2)
    masA[2], err = integrate.quad(a2, -2, 2)
    return masA


def fivePointsAnswer(chekA, b, masA, h):
    start = time.time_ns()
    answer = 0
    a = chekA
    for i in range(int((b-chekA)/h)):
        a += i * h
        answer += fivePoints(a, masA, h)
    print("Время")
    print((time.time_ns() - start) / 1000000000)
    return answer


def fivePoints(a, masA, h):
    answer = 0
    for j in range(len(masA)):
        answer += fun(a + j * h / 4) * masA[j]
    return answer*h/4


def gauss3Answer(a, b, h):
    start = time.time_ns()
    checkA = a
    checkB = b
    answer = 0
    for i in range(int((checkB-checkA)/h)):
        answer += gauss3(a, a + h)
        a += h
    print("Время")
    print((time.time_ns() - start) / 1000000000)
    return answer


def gauss3(a, b):
    A = [5, 8, 5]
    constants = [-(3/5)**(1/2), 0, (3/5)**(1/2)]
    answer = 0
    for j in range(len(A)):
        answer += (b-a)/18*A[j]*fun((a + b)/2 + constants[j]*(b - a)/2)
    return answer


def gauss3VariableH(a, h1):
    endB = 2
    answer = 0
    print("Метод Гаусса-3 с выбором шага")
    start = time.time_ns()
    i = 0
    masH = []
    masI = []
    while True:
        i += 1
        masH.append(h1)
        masI.append(i)
        if a + h1 > b:
            h1 = b - a
            masH.pop()
            masH.append(h1)
        eps = 10**(-12)*h1/(4)
        I1 = gauss3(a, a+h1)
        I2 = gauss3(a, a+h1/2) + gauss3(a+h1/2, a+h1)
        k = (I2 - I1)/(h1**5-(h1/2)**5)

        if np.fabs(k*h1**5) <= eps:
            answer += I1
            a += h1
        if k != 0:
            h1 = 0.8 * (eps / np.fabs(k)) ** (1 / 5)
        if a >= endB:
            break
    print("Время")
    print((time.time_ns() - start) / 1000000000)
    # graph(masH, masI)
    return answer, masH, masI


def fivePointsVariableH(a, masA, h1):
    endB = 2
    answer = 0
    print("Метод по 5 узлам с выбором шага")
    start = time.time_ns()
    i =0
    masH = []
    masI = []
    while True:

        if a + h1 > b:
            h1 = b - a
            masH.pop()
            masH.append(h1)
        eps = 10**(-12)*h1/(4)
        I1 = fivePoints(a, masA, h1)
        I2 = fivePoints(a, masA, h1/2) + fivePoints(a+h1/2, masA, h1/2)
        k = (I2 - I1)/(h1**5-(h1/2)**5)

        if np.fabs(k*h1**5) <= eps:
            i += 1
            masH.append(h1)
            masI.append(i)
            answer += I1
            a += h1
        h1 = 0.8 * (eps / np.fabs(k)) ** (1 / 5)
        if a >= endB:
            break
    print("Время")
    print((time.time_ns() - start) / 1000000000)
    # graph(masH, masI)
    return answer, masH, masI


def graph(masH, masI, masH1, masI1):
    fig = plt.subplots()
    plt.plot(masI, masH, "green")
    # plt.plot(masI1, masH1)
    plt.show()


if __name__ == '__main__':
    a, b = -2, 2
    masX = [-2 + i for i in range(5)]
    masA = searchA(masX)
    answerAn, err = integrate.quad(fun, a, b)
    print("Точное значение")
    print(answerAn)
    print("Метод по 5 узлам")
    for i in range(3):
        print("для i = ", i)
        answer = fivePointsAnswer(a, b, masA, (b - a)/1024**i)
        print("Ответ: ", answer)
        print("Погрешность")
        print(answerAn - answer)
    print("Метод Гаусса-3")
    for i in range(3):
        print("для i = ", i)
        answer = gauss3Answer(a, b,  (b - a)/1024**i)
        print("Ответ: ", answer)
        print("Погрешность")
        print(answerAn - answer)

    answer1 = fivePointsVariableH(a, masA, 1)
    print(answer1[0])
    print("Погрешность")
    print(answerAn - answer1[0])

    answer2 = gauss3VariableH(a, 1)
    print(answer2[0])
    print("Погрешность")
    print(answerAn - answer2[0])
    graph(answer1[1], answer1[2], answer2[1], answer2[2])



