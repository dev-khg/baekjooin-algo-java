import collections
import heapq
import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())

out_side = (1, m + 1)
distance = []

for i in range(k):
    f, d = map(int, input().split())
    distance.append((i, abs(f - out_side[0]) + abs(d - out_side[1])))

distance.sort(key=lambda x:(x[1], x[0]))

print(distance[0][0] + 1)