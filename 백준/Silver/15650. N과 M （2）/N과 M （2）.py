import collections
import heapq
import sys

input = sys.stdin.readline


N, M = map(int, input().split())
used = [False] * (N + 1)
answer = []


def dfs(L: int, s: int, picked):
    global N, M

    if L == M:
        temp = []
        for pick in picked:
            temp.append(pick)
        answer.append(temp)
        return

    for i in range(s, N + 1):
        if not used[i]:
            used[i] = True
            picked.append(i)
            dfs(L + 1, i + 1, picked)
            picked.pop()
            used[i] = False

dfs(0, 1, [])

for i in answer:
    print(*i)