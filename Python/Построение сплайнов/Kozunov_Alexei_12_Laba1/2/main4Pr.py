import math
import time

import matplotlib.pyplot as plt


import numpy as np


def fun(_x):
    return math.exp(-2*_x) * math.sin(7*_x)


def y2(x, masGL):
    f = [0] * len(x)
    for i in range(100):
        for j in range(len(masGL)):
            f[i] += masGL[j]*x[i]**(j)
    return f


def graph(a):
    y = lambda x: np.exp(-2*x) * np.sin(7*x)
    #y1 = lambda x: a[6]*x**6+a[5]*x**5+a[4]*x**4+a[3]*x**3+a[2]*x**2+a[1]*x+a[0]
    fig = plt.subplots()

    x = np.linspace(-2, 2, 100)
    plt.plot(x, y(x), "green")
    plt.plot(x, y2(x, a), "red")
    plt.show()


def gamma(masX, n):
    masGamma = [[0 for j in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(i, n):
            for k in range(100):
                masGamma[i][j] += masX[k]**i * masX[k]**j
                masGamma[j][i] = masGamma[i][j]
    return masGamma


def beta(masX, n):
    masBeta = [0 for i in range(n)]
    for i in range(n):
        for k in range(100):
            masBeta[i]+=fun(masX[k])*masX[k]**i
    return masBeta


if __name__ == '__main__':
    print("Для 6:")
    print("Время")
    start = time.time_ns()
    masX = np.random.uniform(-2, 2, size=(100))
    masGamma = gamma(masX, 7)
    masBeta = beta(masX, 7)
    a = np.linalg.solve(masGamma, masBeta)
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(a)):
        print(a[i], "*x^", i, "+", end=' ')
    graph(a)
    print("\n")
    print("Для 1:")
    print("Время")
    start = time.time_ns()
    masGamma2 = gamma(masX, 2)
    masBeta2 = beta(masX, 2)
    a2 = np.linalg.solve(masGamma2, masBeta2)
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(a2)):
        print(a2[i], "*x^", i, "+", end=' ')
    graph(a2)
    print("\n")
    print("Для 2:")
    print("Время")
    start = time.time_ns()
    masGamma3 = gamma(masX, 3)
    masBeta3 = beta(masX, 3)
    a3 = np.linalg.solve(masGamma3, masBeta3)
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(a3)):
        print(a3[i], "*x^", i, "+", end=' ')
    graph(a3)
    print("\n")
    print("Для 4:")
    print("Время")
    start = time.time_ns()
    masGamma4 = gamma(masX, 5)
    masBeta4 = beta(masX, 5)
    a4 = np.linalg.solve(masGamma4, masBeta4)
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(a4)):
        print(a4[i], "*x^", i, "+", end=' ')
    graph(a4)








