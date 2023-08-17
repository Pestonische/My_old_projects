import math
import matplotlib.pyplot as plt

import numpy as np


def firstFun(_x, _y):
    return math.exp(-2*_x)+_x/_y-1


def secondFun(_x, _y):
    return math.sin(_x)+_y-2


def jacobi(_x, _y, _h1, _h2):
    return [[(firstFun(_x + _h1, _y) - firstFun(_x, _y)) / _h1, (firstFun(_x, _y + _h2)-firstFun(_x, _y)) / _h2],
            [(secondFun(_x + _h1, _y)-secondFun(_x, _y)) / _h1, (secondFun(_x, _y + _h2)-secondFun(_x, _y)) / _h2]]


def graph():
    y = lambda x: -x / (np.exp(-2 * x) - 1)
    y1 = lambda x: 2 - np.sin(x)
    fig = plt.subplots()
    x = np.linspace(-5, 5, 100)
    plt.plot(x, y(x), "green")
    plt.plot(x, y1(x), "red")
    plt.show()


if __name__ == '__main__':
    graph()
    h = [0.000005, 0.000005]
    x0, y0 = 0.5, 0.8
    x, y = x0, y0
    xt = [x, y]
    e = 10**(-6)
    i = 0
    print("Итерации:")
    while np.sqrt(xt[0]**2 + xt[1]**2) > e:
        i += 1
        print(i)
        v = np.array([-firstFun(x, y), -secondFun(x, y)])
        A = np.array(jacobi(x, y, h[0], h[1]))
        xt = np.linalg.solve(A, v)
        x += xt[0]
        y += xt[1]
    print("x, y:")
    print(x, y)
    print("f1:")
    print(firstFun(x, y))
    print("f2")
    print(secondFun(x, y))








