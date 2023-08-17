from matplotlib import pyplot
import numpy

N = 2 ** 20 + 1


def get_bit(value, n):
    return (value >> n & 1) != 0


def set_bit(value, n):
    return value | (1 << n)


if __name__ == "__main__":
    current = 16
    i1 = 5
    i2 = 3
    length = 5

    register_1 = []
    for i in range(0, N):
        position_first = length - i1
        position_second = length - i2
        first = get_bit(current, position_first)
        second = get_bit(current, position_second)
        new = first ^ second
        result = current >> 1
        if new:
            result = set_bit(result, length - 1)
        current = result
        register_1.append(result)

    current = 512
    i1 = 10
    i2 = 7
    length = 10
    register_2 = []

    for i in range(0, N):
        position_first = length - i1
        position_second = length - i2
        first = get_bit(current, position_first)
        second = get_bit(current, position_second)
        new = first ^ second
        result = current >> 1
        if new:
            result = set_bit(result, length - 1)
        current = result
        register_2.append(result)

    pyplot.scatter(numpy.arange(0, len(register_1), 1), register_1, 0.5, 'r')
    pyplot.show()

    pyplot.scatter(numpy.arange(0, len(register_2), 1), register_2, 0.5, 'r')
    pyplot.show()
