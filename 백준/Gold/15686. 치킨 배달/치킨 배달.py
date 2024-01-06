import heapq
import itertools
import sys

input = sys.stdin.readline
N, M = map(int, input().split())

board = []
houses = []
chickens = []

for i in range(N):
    board.append([int(s) for s in input().split()])
    for j in range(N):
        if board[i][j] == 1:
            houses.append((i, j))
        elif board[i][j] == 2:
            chickens.append((i, j))

answer = sys.maxsize

for selected in itertools.combinations(chickens, M):
    total_value = 0
    for house in houses:
        distance = sys.maxsize
        for chicken in selected:
            distance = min(distance, abs(chicken[0] - house[0]) + abs(chicken[1] - house[1]))
        total_value += distance
    answer = min(answer, total_value)

print(answer)
