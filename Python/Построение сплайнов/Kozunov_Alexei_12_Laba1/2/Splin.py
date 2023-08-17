import math
import time

import matplotlib.pyplot as plt
import numpy as np


def fun(_x):
    return math.exp(-2*_x) * math.sin(7*_x)


def dotsSplin(x1, x2, n):
    return (x1-x2)/(n-1)


def alpha(masX):
    return [fun(masX[i]) for i in range(1, len(masX))]


def b(masX):
    masB = [fun(masX[i]) for i in range(len(masX))]
    for i in range(2):
        for j in range(1, len(masX)-i):
            masB[j-1]=(masB[j]-masB[j-1])/(masX[j+i]-masX[j-1])
    return [masB[i]*6 for i in range(len(masX) - 2)]


def gamma(e, masB):
    d = [2 for i in range(len(masB))]
    masGamma = [0 for i in range(len(masB)+1)]
    for i in range(1, len(masB)):
        cd = e/d[i-1]
        d[i] -= e*cd
        masB[i] -= masB[i-1]*cd
    masGamma[len(masB) - 1] = masB[len(masB) - 1] / d[len(masB) - 1]
    for i in range(len(masB) - 2, -1, -1):
        masGamma[i] = (masB[i] - e*masGamma[i+1]) / d[i]
    return masGamma


def delta(masGamma, h):
    masDelta = [masGamma[0]/h for i in range(len(masGamma))]
    for i in range(1, len(masGamma)):
        masDelta[i] = (masGamma[i] - masGamma[i - 1]) / h
    return masDelta


def beta(masX, masGamma, h):
    masY = [fun(masX[i]) for i in range(len(masX))]
    masBeta = [(masY[1]-masY[0])/h+2*masGamma[0]*h/6 for i in range(1, len(masY))]
    for i in range(2, len(masY)):
        masBeta[i-1] = (masY[i]-masY[i-1])/h+(2*masGamma[i-1]+masGamma[i-2])*h/6
    return masBeta


def graph(masX, masAlpha, masBeta, masGamma, masDelta):
    y = lambda x: np.exp(-2*x) * np.sin(7*x)
    y2 = [y for i in range(len(masAlpha))]
    for i in range(len(masAlpha)):
        y2[i] = lambda x: masAlpha[i]+masBeta[i]*(x-masX[i+1])+(masGamma[i]*(x-masX[i+1])**2)/2+(masDelta[i]*(x-masX[i+1])**3)/6

    fig = plt.subplots()
    x = np.linspace(-2, 2, 100)
    plt.plot(x, y(x), "green")
    for i in range(len(masAlpha)):
        x_i = np.linspace(masX[i], masX[i+1], 20)
        plt.plot(x_i, y2[i](x_i))
    plt.show()


if __name__ == '__main__':
    print("На 6:")
    print("Время")
    start = time.time_ns()
    h = dotsSplin(2, -2, 6)
    masX = [-2 + h * i for i in range(6)]
    masAlpha = alpha(masX)
    c, e = h/(2*h), h/(2*h)
    masB = b(masX)
    masGamma = gamma(e, masB)
    masDelta = delta(masGamma, h)
    masBeta = beta(masX, masGamma, h)
    print((time.time_ns() - start) / 1000000000)
    print("Многочлен")
    for i in range(len(masAlpha)):
        print(masAlpha[i],"+", masBeta[i], "*(x-", masX[i+1],")+(",masGamma[i],"*(x-",masX[i+1],")^2)/2+(",masDelta[i],"*(x-",masX[i+1],")^3)/6")
    graph(masX, masAlpha, masBeta, masGamma, masDelta)

    print("На 12:")
    print("Время")
    start2 = time.time_ns()
    h2 = dotsSplin(2, -2, 12)
    masX2 = [-2 + h2 * i for i in range(12)]
    masAlpha2 = alpha(masX2)
    c2, e2 = h2 / (2 * h2), h2 / (2 * h2)
    masB2 = b(masX2)
    masGamma2 = gamma(e2, masB2)
    masDelta2 = delta(masGamma2, h2)
    masBeta2 = beta(masX2, masGamma2, h2)
    print((time.time_ns() - start2) / 1000000000)
    print("Многочлен")
    for i in range(len(masAlpha2)):
        print(masAlpha2[i], "+", masBeta2[i], "*(x-", masX2[i + 1], ")+(", masGamma2[i], "*(x-", masX2[i + 1], ")^2)/2+(",
              masDelta2[i], "*(x-", masX2[i + 1], ")^3)/6")
    graph(masX2, masAlpha2, masBeta2, masGamma2, masDelta2)

    print("На 18:")
    print("Время")
    start3 = time.time_ns()
    h3 = dotsSplin(2, -2, 18)
    masX3 = [-2 + h3 * i for i in range(18)]
    masAlpha3 = alpha(masX3)
    c3, e3 = h3 / (2 * h3), h3 / (2 * h3)
    masB3 = b(masX3)
    masGamma3 = gamma(e3, masB3)
    masDelta3 = delta(masGamma3, h3)
    masBeta3 = beta(masX3, masGamma3, h3)
    print((time.time_ns() - start3) / 1000000000)
    print("Многочлен")
    for i in range(len(masAlpha3)):
        print(masAlpha3[i], "+", masBeta3[i], "*(x-", masX3[i + 1], ")+(", masGamma3[i], "*(x-", masX3[i + 1], ")^2)/2+(",
              masDelta3[i], "*(x-", masX3[i + 1], ")^3)/6")
    graph(masX3, masAlpha3, masBeta3, masGamma3, masDelta3)










