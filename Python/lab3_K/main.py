import collections
import hashlib
import random

EllipticCurve = collections.namedtuple('EllipticCurve', 'p a b g n h')

curve = EllipticCurve(
    # Field characteristic.
    p=59,
    # Curve coefficients.
    a=131,
    b=3,
    # Base point.
    g=(38, 26),
    # Subgroup order.
    n=37,
    # Subgroup cofactor.
    h=2,
)

def inverse_mod(k, p):
    """Returns the inverse of k modulo p.
    This function returns the only integer x such that (x * k) % p == 1.
    k must be non-zero and p must be a prime.
    """
    if k == 0:
        raise ZeroDivisionError('division by zero')

    if k < 0:
        # k ** -1 = p - (-k) ** -1  (mod p)
        return p - inverse_mod(-k, p)

    s, old_s = 0, 1
    t, old_t = 1, 0
    r, old_r = p, k

    while r != 0:
        quotient = old_r // r
        old_r, r = r, old_r - quotient * r
        old_s, s = s, old_s - quotient * s
        old_t, t = t, old_t - quotient * t

    gcd, x, y = old_r, old_s, old_t

    assert gcd == 1
    assert (k * x) % p == 1

    return x % p


def is_on_curve(point):
    if point is None:
        # None represents the point at infinity.
        return True

    x, y = point

    return (y * y - x * x * x - curve.a * x - curve.b) % curve.p == 0


def point_neg(point):
    assert is_on_curve(point)

    if point is None:
        # -0 = 0
        return None

    x, y = point
    result = (x, -y % curve.p)

    assert is_on_curve(result)

    return result


def point_add(point1, point2):
    assert is_on_curve(point1)
    assert is_on_curve(point2)

    if point1 is None:
        return point2
    if point2 is None:
        return point1

    x1, y1 = point1
    x2, y2 = point2

    if x1 == x2 and y1 != y2:
        return None

    if x1 == x2:
        m = (3 * x1 * x1 + curve.a) * inverse_mod(2 * y1, curve.p)
    else:
        m = (y1 - y2) * inverse_mod(x1 - x2, curve.p)

    x3 = m * m - x1 - x2
    y3 = y1 + m * (x3 - x1)
    result = (x3 % curve.p,
              -y3 % curve.p)

    assert is_on_curve(result)

    return result


def scalar_mult(k, point):
    assert is_on_curve(point)

    if k % curve.n == 0 or point is None:
        return None

    if k < 0:
        return scalar_mult(-k, point_neg(point))

    result = None
    addend = point

    while k:
        if k & 1:
            result = point_add(result, addend)

        addend = point_add(addend, addend)

        k >>= 1

    assert is_on_curve(result)

    return result

def make_keypair():
    private_key = random.randrange(1, curve.n)
    public_key = scalar_mult(private_key, curve.g)

    return private_key, public_key


def hash_message(message):
    message_hash = hashlib.sha512(message).digest()
    e = int.from_bytes(message_hash, 'big')
    z = e >> (e.bit_length() - curve.n.bit_length())

    assert z.bit_length() <= curve.n.bit_length()

    return z


def sign_message(private_key, message):
    z = hash_message(message)

    r = 0
    s = 0

    while not r or not s:
        k = random.randrange(1, curve.n)
        x, y = scalar_mult(k, curve.g)

        r = x % curve.n
        s = ((z + r * private_key) * inverse_mod(k, curve.n)) % curve.n

    return r, s


def verify_signature(public_key, message, signature):
    z = hash_message(message)

    r, s = signature

    w = inverse_mod(s, curve.n)
    u1 = (z * w) % curve.n
    u2 = (r * w) % curve.n

    x, y = point_add(scalar_mult(u1, curve.g),
                     scalar_mult(u2, public_key))

    if (r % curve.n) == (x % curve.n):
        return 'signature matches'
    else:
        return 'invalid signature'


if __name__ == '__main__':

    # Alice generates her own keypair.
    alice_private_key, alice_public_key = make_keypair()
    print("Alice's private key:", hex(alice_private_key))
    print("Alice's public key: (0x{:x}, 0x{:x})".format(*alice_public_key))

    # Bob generates his own key pair.
    bob_private_key, bob_public_key = make_keypair()
    print("Bob's private key:", hex(bob_private_key))
    print("Bob's public key: (0x{:x}, 0x{:x})".format(*bob_public_key))

    # Alice and Bob exchange their public keys and calculate the shared secret.
    s1 = scalar_mult(alice_private_key, bob_public_key)
    s2 = scalar_mult(bob_private_key, alice_public_key)
    assert s1 == s2

    print('Shared secret: (0x{:x}, 0x{:x})'.format(*s1))

    print('\n---------------------------------------------')

    private, public = make_keypair()
    print("Private key:", hex(private))
    print("Public key: (0x{:x}, 0x{:x})".format(*public))

    msg = b'Hello!'
    signature = sign_message(private, msg)

    print()
    print('Message:', msg)
    print('Signature: (0x{:x}, 0x{:x})'.format(*signature))
    print('Verification:', verify_signature(public, msg, signature))

    msg = b'Hi!'
    print()
    print('Message:', msg)
    print('Verification:', verify_signature(public, msg, signature))

    private, public = make_keypair()

    msg = b'Hello!'
    print()
    print('Message:', msg)
    print("Public key: (0x{:x}, 0x{:x})".format(*public))
    print('Verification:', verify_signature(public, msg, signature))
