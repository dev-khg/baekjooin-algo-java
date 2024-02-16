import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

def gcd(a: int, b: int) -> int:
    if a < b:
        a, b = b, a
    r = a % b
    if r == 0:
        return b
    return gcd(b, r)


gcd_ret = gcd(N, M)
print(gcd_ret)
print(N * M // gcd_ret)