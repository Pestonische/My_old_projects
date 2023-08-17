from main_task import alphabet

possible_keys = {3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25}

code_dict = {}
decode_dict = {}
current_key = 0
lens = len(alphabet)

def prepare_encoding(key: int):
    for index in range(0, lens):
        code_index = (index * key + 3) % lens
        code_dict[alphabet[index]] = alphabet[code_index]
        global decode_dict
        decode_dict = {x: y for y, x in code_dict.items()}


def encode(message: str, key: int) -> str:
    if key not in possible_keys:
        raise ArithmeticError
    prepare_encoding(key)
    encoded_str = "".join([code_dict[i] for i in message])
    return encoded_str


def decode(message: str, key: int) -> str:
    if key not in possible_keys:
        raise ArithmeticError
    prepare_encoding(key)
    decoded_str = "".join([decode_dict[i] for i in message])
    return decoded_str


if __name__ == '__main__':
    test_str = "ASDFGHJKLZXCVBNM"
    print("Encoding {}:".format(test_str), encode(test_str, 23))
    print("Decoding {}:".format(encode(test_str, 23)), decode(encode(test_str, 23), 23))

