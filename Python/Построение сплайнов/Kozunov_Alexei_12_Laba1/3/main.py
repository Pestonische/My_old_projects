import math
import time

import matplotlib.pyplot as plt

import numpy as np

from matplotlib import cm


def fun(_x, _y):
    return (_x+_y)*math.cos(_x)*math.cos(_y)


def dotsLagranga(x1, x2, n):
    return (x1-x2)/(n-1)


def f(x, y, masX, masY, masXiMinusXj, masYiMinusYj):
    f = 0
    for i in range(len(masX)):
        sum = 0
        for j in range(len(masX)):
            fx = 1
            fy = 1
            for k in range(len(masX)):
                if k != i:
                    fx *= (x - masX[k])
            for k in range(len(masX)):
                if k != j:
                    fy *= (y - masY[k])
            sum += fx * fy * fun(masX[i], masY[j])/(masXiMinusXj[i]*masYiMinusYj[j])
        f+=sum
    return f


def graph(masX, masY, masXiMinusXj, masYiMinusYj):
    f1 = lambda x, y: (x+y)*np.cos(x)*np.cos(y)
    fig = plt.figure(figsize=(11, 11))
    ax = fig.add_subplot(1, 1, 1, projection='3d')
    xval = np.linspace(0, 11, 100)
    yval = np.linspace(0, 11, 100)
    x, y = np.meshgrid(xval, yval)
    f4 = [[0 for i in range(100)] for j in range(100)]
    start = time.time_ns()
    for i in range(100):
        for j in range(100):
            f4[i][j] = f(x[i][j], y[i][j], masX, masY, masXiMinusXj, masYiMinusYj)
    print((time.time_ns() - start) / 1000000000, "сек")
    #z = np.array(f4)
    z = f1(x, y)
    surf = ax.plot_surface(
        x, y, z,
        rstride=10,
        cstride=10,
        cmap=cm.plasma)
    plt.show()


if __name__ == '__main__':

    print("На 6х6:")
    print("Время")
    start = time.time_ns()
    k = dotsLagranga(11, 0, 6)
    masX = [0 + k * i for i in range(6)]
    masY = [0 + k * i for i in range(6)]
    masXiMinusXj = [1 for i in range(6)]
    masYiMinusYj = [1 for i in range(6)]
    for i in range(len(masX)):
        for j in range(len(masX)):
            if i != j:
                masXiMinusXj[i] *= (masX[i] - masX[j])
                masYiMinusYj[i] *= (masY[i] - masY[j])
    print((time.time_ns()-start)/1000000000, "сек")

    graph(masX, masY, masXiMinusXj, masYiMinusYj)
    print(" ")
    print("На 12х12:")
    print("Время")
    start = time.time_ns()
    k2 = dotsLagranga(11, 0, 12)
    masX2 = [0 + k2 * i for i in range(12)]
    masY2 = [0 + k2 * i for i in range(12)]
    masXiMinusXj2 = [1 for i in range(12)]
    masYiMinusYj2 = [1 for i in range(12)]
    for i in range(len(masX2)):
        for j in range(len(masX2)):
            if i != j:
                masXiMinusXj2[i] *= (masX2[i] - masX2[j])
                masYiMinusYj2[i] *= (masY2[i] - masY2[j])
    print((time.time_ns() - start) / 1000000000, "сек")

    graph(masX2, masY2, masXiMinusXj2, masYiMinusYj2)
    print(" ")
    print("На 18х18:")
    print("Время")
    start = time.time_ns()
    k3 = dotsLagranga(11, 0, 18)
    masX3 = [0 + k3 * i for i in range(18)]
    masY3 = [0 + k3 * i for i in range(18)]
    masXiMinusXj3 = [1 for i in range(18)]
    masYiMinusYj3 = [1 for i in range(18)]
    for i in range(len(masX3)):
        for j in range(len(masX3)):
            if i != j:
                masXiMinusXj3[i] *= (masX3[i] - masX3[j])
                masYiMinusYj3[i] *= (masY3[i] - masY3[j])
    print((time.time_ns() - start) / 1000000000, "сек")

    graph(masX3, masY3, masXiMinusXj3, masYiMinusYj3)






