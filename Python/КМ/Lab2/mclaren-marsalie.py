import numpy
from matplotlib import pyplot

N = 2 ** 20 + 1


def generate_1(x01: int, A1: int, C1: int, M1: int):
    result = []
    for i in range(0, N):
        x01 = (x01 * A1 + C1) % M1
        randint = x01 / M1
        result.append(randint)
    return result


def generate_2(x02_1: int, A2: int, C2: int, M2: int):
    result = []
    for i in range(0, N):
        x02_1 = (x02_1 * A2 + C2) % M2
        randint = x02_1 / M2
        result.append(randint)
    return result


if __name__ == '__main__':
    M1 = 75
    M1_2 = 64
    A1 = 16
    A1_2 = 17
    C1 = 7
    C1_2 = 11
    x01 = 52
    x01_2 = 35

    table_1 = generate_1(x01, A1, C1, M1)
    result_1 = []

    file_1 = open("marsalie_1.txt", "w")

    for _ in range(N):
        x01_2 = (x01_2 * A1_2 + C1_2) % M1_2
        randint_1 = x01_2 / M1_2
        rand_index =int(randint_1 * N)
        element = table_1[rand_index]
        x01 = (x01 * A1 + C1) % M1
        randint_2 = x01 / M1
        table_1[rand_index] = randint_2
        randint = element
        result_1.append(randint)
        print(randint, file=file_1)

    file_1.close()

    M2 = 9_686_016  # 1051 * 2 ** 9 *
    M2_2 = 314_041
    A2 = 181
    A2_2 = 378
    C2 = 7
    C2_2 = 11
    x02_1 = 4_879_737
    x02_2 = 65339

    table_2 = generate_2(x02_1, A2, C2, M2)
    result_2 = []

    file_2 = open("marsalie_2.txt", "w")

    for _ in range(N):
        x02_2 = (x02_2 * A2_2 + C2_2) % M2_2
        randint_3 = x02_2 / M2_2
        rand_index = int(randint_3 * N)
        element = table_2[rand_index]
        x02_1 = (x02_1 * A2 + C2) % M2
        randint_4 = x02_1 / M2
        table_2[rand_index] = randint_4
        randint = element
        result_2.append(randint)
        print(randint, file=file_2)

    file_2.close()

    pyplot.scatter(numpy.arange(0, len(result_1), 1), result_1, 0.5, 'r')
    pyplot.show()

    pyplot.scatter(numpy.arange(0, len(result_2), 1), result_2, 0.1, 'r')
    pyplot.show()
