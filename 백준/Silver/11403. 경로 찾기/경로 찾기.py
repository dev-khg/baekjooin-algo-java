import collections
import heapq
import itertools
import sys


input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][k] and graph[k][j]:
                graph[i][j] = 1


for i in range(N):
    print(*graph[i], sep=' ')