import collections
import sys

input = sys.stdin.readline

N, L = map(int, input().split())
water = [list(map(int, input().split())) for _ in range(N)]
water.sort()

cnt = 0
before = 0
for a, b in water:
    if before > a:
        a = before

    while a < b:
        a += L
        cnt += 1
    before = a

print(cnt)