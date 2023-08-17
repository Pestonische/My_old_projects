import random
import timeit
import scipy.special as sc
import math

from sympy.physics.continuum_mechanics.beam import numpy


def to_stringbits(text):
    i = 0
    bits = ''
    n = len(text)
    while i < n:
        for j in range(0, 8):
            bits += str(((text[i] >> j) & 1))
        i += 1
    return bits



class ApproximateEntropyTest:
    @staticmethod
    def approximate_entropy(pattern_length, bin_data: bytes):
        """
        Note that this description is taken from the NIST documentation [1]
        [1] http://csrc.nist.gov/publications/nistpubs/800-22-rev1a/SP800-22rev1a.pdf
        As with the Serial test of Section 2.11, the focus of this test is the frequency of all possible overlapping
        m-bit patterns across the entire sequence. The purpose of the test is to compare the frequency of overlapping
        blocks of two consecutive/adjacent lengths (m and m+1) against the expected result for a random sequence.
        :param bin_data: a binary string
        :param pattern_length: the length of the pattern (m)
        :return: the P value
        """

        bin_data = to_stringbits(bin_data)
        n = len(bin_data)
        print(n)
        pattern_length = 5
        # Add first m+1 bits to the end
        # NOTE: documentation says m-1 bits but that doesnt make sense, or work.
        bin_data += bin_data[:pattern_length + 1:]
        # bin_data += bin_data[:pattern_length - 1:]

        # Get max length one patterns for m, m-1, m-2
        max_pattern = ''
        for i in range(pattern_length + 2):
            max_pattern += '1'

        # Keep track of each pattern's frequency (how often it appears)
        vobs_one = numpy.zeros(int(max_pattern[0:pattern_length:], 2) + 1)
        vobs_two = numpy.zeros(int(max_pattern[0:pattern_length + 1:], 2) + 1)

        for i in range(n):
            # Work out what pattern is observed
            vobs_one[int(bin_data[i:i + pattern_length:], 2)] += 1
            vobs_two[int(bin_data[i:i + pattern_length + 1:], 2)] += 1

        # Calculate the test statistics and p values
        vobs = [vobs_one, vobs_two]
        sums = numpy.zeros(2)
        for i in range(2):
            for j in range(len(vobs[i])):
                if vobs[i][j] > 0:
                    sums[i] += vobs[i][j] * math.log(vobs[i][j] / n)
        sums /= n
        ape = sums[0] - sums[1]
        chi_squared = 2.0 * n * (math.log(2) - ape)
        p_val = sc.gammaincc(pow(2, pattern_length - 1), chi_squared / 2.0)
        print(f'P-value: {p_val}')
        return p_val


    @staticmethod
    def is_random(pattern_length, text):
        return ApproximateEntropyTest.approximate_entropy(pattern_length, text) >= 0.01




class Crypto:
    keys = []

    def __init__(self, key, d: int):
        if d < 0:
            return
        self.key = key
        self.d = d
        key_ = key
        for i in range(0, d):
            # 256 - байт
            self.keys.append(key_ % 256)
            key_ = key_ >> 8
        self.keys.reverse()


    @staticmethod
    def unite(x1: int, x2: int):
        return (x1 << 4) | x2

    def right_way(self, x1: int, x2: int, key: int):
        y2 = x2 ^ key
        s = Crypto.divide(y2)
        y2 = Crypto.unite(Crypto.s1(s[0]), Crypto.s2(s[1]))
        y2 = Crypto.right(y2, 3)
        y2 = y2 ^ x1
        return y2

    def encrypt(self, text):
        length = len(text)
        length = length - length % 2
        i = 0
        while i < length:
            x1 = text[i]
            i+=1
            x2 = text[i]
            y1: int
            y2: int
            for d_ in range(0, self.d):
                y1 = x2
                y2 = Crypto.right_way(self, x1, x2, self.keys[d_])
                x1 = y1
                x2 = y2

            text[i - 1] = y1
            text[i] = y2
            i += 1
        return text

    def decrypt(self, text):
        length = len(text)
        length = length - length % 2
        i = 0
        while i < length:
            y1 = text[i]
            i = i + 1
            y2 = text[i]
            x1: int
            x2: int
            j = self.d - 1
            while j >= 0:
                x2 = y1
                x1 = Crypto.right_way(self, y2, y1, self.keys[j])
                y1 = x1
                y2 = x2
                j -= 1
            text[i - 1] = x1
            text[i] = x2
            i = i + 1
        return text

    @staticmethod
    def divide(x: int):
        res = []
        # 15 = 0000 1111
        firstHalf = x & 15
        # 240 = 1111 0000
        secondHalf = (x & 240) >> 4
        return secondHalf, firstHalf

    @staticmethod
    def left(x: int, delta: int):
        # 256 - байт
        max = (256)
        x = x % max
        x_ = x >> (8 - delta)
        x_ = ((x << delta) % max) | x_
        return x_

    @staticmethod
    def right(x: int, delta: int):
        # 256 - байт
        max = (256)
        x = x % max
        x_ = (x << (8 - delta)) % max
        x_ = x_ | (x >> delta)
        return x_

    @staticmethod
    def s1(x: int):
        return ((3 ** x) % 17 + 2) % 16

    @staticmethod
    def s2(x: int):
        return ((5 ** x) % 17 + 7) % 16

    def encrypt_from_file(self, filein):
        f = open(filein, "rb")
        text = bytearray(f.read())
        f.close()
        return self.encrypt(text)

    def encrypt_from_file_to_file(self, filein, fileout):
        text = self.encrypt_from_file(filein)
        f = open(fileout, "wb")
        f.write(text)
        f.close()
        return text

    def decrypt_from_file(self, filein):
        f = open(filein, "rb")
        text = bytearray(f.read())
        f.close()
        return self.decrypt(text)

    def decrypt_from_file_to_file(self, filein, fileout):
        text = self.decrypt_from_file(filein)
        f = open(fileout, "wb")
        f.write(text)
        f.close()
        return text

if '__main__':
    filein, filekey, efileout, dfileout = 'e.bin', 'key', 'efileout', 'dfileout'

    f = open(filekey, 'rb')
    key = int.from_bytes(f.read(4), 'little')
    f.close()
    f = open('e.bin', "rb")
    etext = f.read()
    pattern_length = int(math.log(len(etext), 2)) - 2
    for i in range(1, 9):
        cr = Crypto(key, i)
        start_time = timeit.default_timer()
        etext = cr.encrypt_from_file_to_file(filein, efileout + str(i))
        end_time = timeit.default_timer()
        print('Encryption time:' + str(end_time - start_time))
        cr.decrypt_from_file_to_file(efileout+str(i), dfileout+str(i))
        print('Is Random: ' + str(ApproximateEntropyTest.is_random(pattern_length, etext)))









