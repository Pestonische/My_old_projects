from main_task import alphabet

lens = len(alphabet)
letter_num = {alphabet[index]: index for index in range(lens)}
table = [0] * lens
for index in range(lens):
    row = [alphabet[(x+index) % lens] for x in range(lens)]
    table[index] = row


def encode(message: str, key: str) -> str:
    _key = key
    while len(_key) < len(message):
        _key += key
    key = _key[:len(message)]

    encoded_str = "".join([alphabet[(letter_num[letter] + letter_num[key[index]]) % lens] for index, letter in enumerate(message)])
    return encoded_str


def decode(message: str, key: str) -> str:
    _key = key
    while len(_key) < len(message):
        _key += key
    key = _key[:len(message)]
    decoded_str = "".join([alphabet[(letter_num[letter] + lens - letter_num[key[index]]) % lens] for index, letter in enumerate(message)])
    return decoded_str


if __name__ == '__main__':
    print('Vigenere table: ')
    for index in range(lens):
        print(index, table[index])
    str = 'ASDFGHJKLZXCVBNM'
    new_str = encode(str, 'QWERTY')
    print('Test encode:', str, "->", new_str)
    print('Test decode:', new_str, "->", decode(new_str, 'QWERTY'))
    