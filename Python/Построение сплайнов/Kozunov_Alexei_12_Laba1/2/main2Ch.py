import math
import time

import matplotlib.pyplot as plt

import numpy as np


def fun(_x):
    return math.exp(-2*_x) * math.sin(7*_x)


def dotsLagranga(x1, x2, n):
    masX_ = [0 for i in range(n)]

    for i in range(n):
        masX_[i] = (x1+x2)/2+((x1-x2)/2)*math.cos((2*i+1)*3.14/(2*n))
    return masX_


def masLagranga(masX):
    lens = len(masX)
    masL = [[0 for j in range(lens)] for i in range(lens)]
    for k in range(lens):
        for i in range(lens):
            for j in range(lens, -1, -1):
                if i == 0:
                    if j == 0:
                        masL[k][j] = 1
                else:
                    if j == 0:
                        masL[k][j] = 1
                    else:
                        if j <= i:
                            masL[k][j] = masX[i-1] * masL[k][j-1] + masL[k][j]
        u = masX[k]
        masX[k] = masX[lens - 1]
        masX[lens - 1] = u
    for i in range(lens):
        for j in range(lens):
            if j % 2 != 0:
                masL[i][j] = -masL[i][j]
    return masL


def y2(x, masGL):
    f = [0] * len(x)
    for i in range(100):
        for j in range(len(masGL)):
            f[i] += masGL[j]*x[i]**(len(masGL)-1-j)
    return f


def graph(masGL):
    y = lambda x: np.exp(-2*x) * np.sin(7*x)
    #y1 = lambda x: masLG[0]*x**5+masLG[1]*x**4+masLG[2]*x**3+masLG[3]*x**2+masLG[4]*x+masLG[5]
    fig = plt.subplots()
    x = np.linspace(-2, 2, 100)
    plt.plot(x, y(x), "green")
    plt.plot(x, y2(x, masGL), "red")
    plt.show()


if __name__ == '__main__':
    print("На 6:")
    print("Время")
    start = time.time_ns()
    masX = dotsLagranga(-2, 2, 6)
    masL = masLagranga(masX)
    masXiMinusXj = [1 for i in range(6)]
    for j in range(6):
        for i in range(len(masX)):
            if (i < j) or (i > j):
                masXiMinusXj[j] *= (masX[j] - masX[i])
    masLG = [0 for i in range(6)]
    for i in range(6):
        for j in range(6):
            masL[i][j] = masL[i][j] * fun(masX[i]) / masXiMinusXj[i]
    for i in range(6):
        for j in range(6):
            masLG[i] += masL[j][i]
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(masLG)):
        print(masLG[i], "*x^", len(masLG) - 1 - i, "+", end=' ')
    graph(masLG)
    print("\n")
    print("На 12:")
    print("Время")
    start = time.time_ns()
    masX2 = dotsLagranga(2, -2, 12)
    masL2 = masLagranga(masX2)
    masXiMinusXj2 = [1 for i in range(12)]
    for j in range(12):
        for i in range(len(masX2)):
            if (i < j) or (i > j):
                masXiMinusXj2[j] *= (masX2[j] - masX2[i])
    masLG2 = [0 for i in range(12)]
    for i in range(12):
        for j in range(12):
            masL2[i][j] = masL2[i][j] * fun(masX2[i]) / masXiMinusXj2[i]
    for i in range(12):
        for j in range(12):
            masLG2[i] += masL2[j][i]
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(masLG2)):
        print(masLG2[i], "*x^", len(masLG2) - 1 - i, "+", end=' ')
    graph(masLG2)
    print("\n")
    print("На 18:")
    print("Время")
    start = time.time_ns()
    masX3 = dotsLagranga(2, -2, 18)
    masL3 = masLagranga(masX3)

    masXiMinusXj3 = [1 for i in range(18)]

    for j in range(18):
        for i in range(len(masX3)):
            if (i < j) or (i > j):
                masXiMinusXj3[j] *= (masX3[j] - masX3[i])
    masLG3 = [0 for i in range(18)]
    for i in range(18):
        for j in range(18):
            masL3[i][j] = masL3[i][j] * fun(masX3[i]) / masXiMinusXj3[i]

    for i in range(18):
        for j in range(18):
            masLG3[i] += masL3[j][i]
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(masLG3)):
        print(masLG3[i], "*x^", len(masLG3) - 1 - i, "+", end=' ')
    graph(masLG3)






