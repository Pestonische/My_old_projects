from matplotlib import pyplot
import numpy

if __name__ == '__main__':
    M1 = 75
    A1 = 16
    C1 = 7
    current_1 = 52
    result_1 = []

    file_1 = open("main_g_1.txt", "w")

    for _ in range(1000):
        current_1 = (current_1 * A1 + C1) % M1
        randint = current_1 / M1
        result_1.append(randint)
        print(randint, file=file_1)

    file_1.close()

    M2 = 9_686_016
    A2 = 181
    C2 = 7
    current_2 = 4_879_737
    result_2 = []

    file_2 = open("main_g_2.txt", "w")
    for _ in range(2_000_000):
        current_2 = (current_2 * A2 + C2) % M2
        randint = current_2 / M2
        result_2.append(randint)
        print(randint, file=file_2)

    file_2.close()

    pyplot.scatter(numpy.arange(0, len(result_1), 1), result_1, 0.5, 'r')
    pyplot.show()

    pyplot.scatter(numpy.arange(0, len(result_2), 1), result_2, 0.1, 'r')
    pyplot.show()

