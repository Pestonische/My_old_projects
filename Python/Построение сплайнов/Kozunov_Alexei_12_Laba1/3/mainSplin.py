import math
import time

import matplotlib.pyplot as plt

import numpy as np

from matplotlib import cm


def fun(_x, _y):
    return (_x+_y)*math.cos(_x)*math.cos(_y)


def dotsSplin(x1, x2, n):
    return (x1-x2)/(n-1)


def alpha(masX, y):
    return [fun(masX[i], y) for i in range(1, len(masX))]


def b(masX, masZ):
    masB = [masZ[i] for i in range(len(masZ))]

    for i in range(2):
        for j in range(1, len(masZ)-i):
            masB[j-1] = (masB[j]-masB[j-1])/(masX[j+i]-masX[j-1])
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


def beta(masX, masGamma, h, masZ):
    masY = [masZ[i] for i in range(len(masZ))]
    masBeta = [(masY[1]-masY[0])/h+2*masGamma[0]*h/6 for i in range(1, len(masY))]
    for i in range(2, len(masY)):
        masBeta[i-1] = (masY[i]-masY[i-1])/h+(2*masGamma[i-1]+masGamma[i-2])*h/6
    return masBeta


def f(x, y, masX, masY, masA, masBet, masG, masD) -> object:
    res = 0

    for i in range(1, len(masX)):
        if x <= masX[i]:
            for k in range(4):
                ras1 = []*4
                for j in range(1, len(masY)):
                    if y <= masY[j]:
                        alphaItog = splineСoefficients(y, masY[j], masA[i-1][0][j-1], masA[i-1][1][j-1],
                                                  masA[i-1][2][j-1],
                                                  masA[i-1][3][j-1])
                        bettaItog = splineСoefficients(y, masY[j], masBet[i-1][0][j-1], masBet[i-1][1][j-1],
                                                  masBet[i-1][2][j-1],
                                                  masBet[i-1][3][j-1])
                        gammaItog = splineСoefficients(y, masY[j], masG[i-1][0][j-1], masG[i-1][1][j-1],
                                                  masG[i-1][2][j-1],
                                                  masG[i-1][3][j-1])
                        deltaItog = splineСoefficients(y, masY[j], masD[i-1][0][j-1], masD[i-1][1][j-1],
                                                  masD[i-1][2][j-1],
                                                  masD[i-1][3][j-1])
                        res = splineСoefficients(x, masX[i], alphaItog, bettaItog, gammaItog, deltaItog)
                        return res
    return res


def splineСoefficients(x, xi, al, b, g, d):
    return al+b*(x-xi)+(g*(x-xi)**2)/2+(d*(x-xi)**3)/6


def graph(masX, masY, masA, masBet, masG, masD):
    f1 = lambda x, y: (x+y)*np.cos(x)*np.cos(y)
    fig = plt.figure(figsize=(11, 11))
    ax = fig.add_subplot(1, 1, 1, projection='3d')
    xval = np.linspace(0, 11, 100)
    yval = np.linspace(0, 11, 100)
    x, y = np.meshgrid(xval, yval)
    f4 = [[0 for i in range(100)] for j in range(100)]

    for i in range(100):
        for j in range(100):
            f4[i][j] = f(x[i][j], y[i][j], masX, masY, masA, masBet, masG, masD)

    z = np.array(f4)
    #print(z)
    #z = f1(x, y)

    surf = ax.plot_surface(
    x, y, z,
    rstride=10,
    cstride=10,
    cmap=cm.plasma)
    plt.show()


def spline(masX, masZ, h):
    masAlpha = [masZ[i] for i in range(1, len(masZ))]
    c, e = h / (2 * h), h / (2 * h)
    masB = b(masX, masZ)

    masGamma = gamma(e, masB)
    masDelta = delta(masGamma, h)
    masBeta = beta(masX, masGamma, h, masZ)
    return [masAlpha, masBeta, masGamma, masDelta]

if __name__ == '__main__':
    print("На 6х6:")
    print("Время")
    start = time.time_ns()
    k = dotsSplin(11, 0, 6)
    masX = [0 + k * i for i in range(6)]
    masY = [0 + k * i for i in range(6)]
    masZ = [[0 for i in range(6)] for j in range(6)]
    for i in range(len(masX)):
        masZ[i] = [fun(masX[j], masY[i]) for j in range(len(masX))]
    masSp = [[0 for i in range(4)] for j in range(len(masX))]
    for i in range(len(masX)):
        masSp[i] = spline(masX, masZ[i], k)

    masA = [[0 for i in range(4)] for j in range(len(masX)-1)]
    masBeta = [[0 for i in range(4)] for j in range(len(masX)-1)]
    masG = [[0 for i in range(4)] for j in range(len(masX)-1)]
    masD = [[0 for i in range(4)] for j in range(len(masX)-1)]
    for i in range(len(masX)-1):
        masA[i] = spline(masY, [masSp[j][0][i] for j in range(len(masX))], k)
        masBeta[i] = spline(masY, [masSp[j][1][i] for j in range(len(masX))], k)
        masG[i] = spline(masY, [masSp[j][2][i] for j in range(len(masX))], k)
        masD[i] = spline(masY, [masSp[j][3][i] for j in range(len(masX))], k)

    print((time.time_ns() - start) / 1000000000, "сек")

    graph(masX, masY, masA, masBeta, masG, masD)

    print(" ")
    print("На 12х12:")
    print("Время")
    start = time.time_ns()
    k2 = dotsSplin(11, 0, 12)
    masX2 = [0 + k2 * i for i in range(12)]
    masY2 = [0 + k2 * i for i in range(12)]
    masZ2 = [[0 for i in range(12)] for j in range(12)]
    for i in range(len(masX2)):
        masZ2[i] = [fun(masX2[j], masY2[i]) for j in range(len(masX2))]
    masSp2 = [[0 for i in range(4)] for j in range(len(masX2))]
    for i in range(len(masX2)):
        masSp2[i] = spline(masX2, masZ2[i], k2)

    masA2 = [[0 for i in range(4)] for j in range(len(masX2) - 1)]
    masBeta2 = [[0 for i in range(4)] for j in range(len(masX2) - 1)]
    masG2 = [[0 for i in range(4)] for j in range(len(masX2) - 1)]
    masD2 = [[0 for i in range(4)] for j in range(len(masX2) - 1)]
    for i in range(len(masX2) - 1):
        masA2[i] = spline(masY2, [masSp2[j][0][i] for j in range(len(masX2))], k2)
        masBeta2[i] = spline(masY2, [masSp2[j][1][i] for j in range(len(masX2))], k2)
        masG2[i] = spline(masY2, [masSp2[j][2][i] for j in range(len(masX2))], k2)
        masD2[i] = spline(masY2, [masSp2[j][3][i] for j in range(len(masX2))], k2)

    print((time.time_ns() - start) / 1000000000, "сек")

    graph(masX2, masY2, masA2, masBeta2, masG2, masD2)
    print(" ")
    print("На 18х18:")
    print("Время")
    start = time.time_ns()
    k3 = dotsSplin(11, 0, 18)
    masX3 = [0 + k3 * i for i in range(18)]
    masY3 = [0 + k3 * i for i in range(18)]
    masZ3 = [[0 for i in range(18)] for j in range(18)]
    for i in range(len(masX3)):
        masZ3[i] = [fun(masX3[j], masY3[i]) for j in range(len(masX3))]
    masSp3 = [[0 for i in range(4)] for j in range(len(masX3))]
    for i in range(len(masX3)):
        masSp3[i] = spline(masX3, masZ3[i], k3)

    masA3 = [[0 for i in range(4)] for j in range(len(masX3) - 1)]
    masBeta3 = [[0 for i in range(4)] for j in range(len(masX3) - 1)]
    masG3 = [[0 for i in range(4)] for j in range(len(masX3) - 1)]
    masD3 = [[0 for i in range(4)] for j in range(len(masX3) - 1)]
    for i in range(len(masX3) - 1):
        masA3[i] = spline(masY3, [masSp3[j][0][i] for j in range(len(masX3))], k3)
        masBeta3[i] = spline(masY3, [masSp3[j][1][i] for j in range(len(masX3))], k3)
        masG3[i] = spline(masY3, [masSp3[j][2][i] for j in range(len(masX3))], k3)
        masD3[i] = spline(masY3, [masSp3[j][3][i] for j in range(len(masX3))], k3)

    print((time.time_ns() - start) / 1000000000, "сек")
    print(masA3)
    print(masBeta3)
    print(masG3)
    print(masD3)
    graph(masX3, masY3, masA3, masBeta3, masG3, masD3)
