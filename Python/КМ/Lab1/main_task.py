import random

alphabet = (
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
    'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
    'S', 'T', 'U', 'V', "W", 'X', 'Y', 'Z')
symbols = (' ', ':', ';', '/', '.', '!', '&', '?', '#', '@')

type = list(alphabet)

for _ in range(26):
    index1 = random.randint(0, 25)
    index2 = random.randint(0, 25)
    type[index1], type[index2] = type[index2], type[index1]

encode_type = {alphabet[i]: type[i] for i in range(26)}

decode_type = {type[i]: alphabet[i] for i in range(26)}


def encode(message: str) -> str:
    encode_str = ""
    for i in message:
        if i not in symbols:
            encode_str += encode_type[i]
        else:
            encode_str += i
    return encode_str


def decode(message: str) -> str:
    decode_str = ""
    for i in message:
        if i not in symbols:
            decode_str += decode_type[i]
        else:
            decode_str += i
    return decode_str


if __name__ == '__main__':
    print("Alphabet for encode: ", alphabet)
    print("Encoding key: ", type)
    print("Encode str: ", encode_type)
    print("Decode str: ", decode_type)
    print("Code of ABCDE", encode("ABCDE"))
    print("Code of {}".format(encode("ABCDE")), decode(encode("ABCDE")))

