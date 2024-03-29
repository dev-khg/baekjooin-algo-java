import collections
import heapq
import sys

input = sys.stdin.readline


N, S = map(int, input().split())
nums = list(map(int, input().split()))
answer = 0


def dfs(idx: int, total: int, count: int):
    global N, answer
    if idx == N:
        if total == S and count > 0:
            answer += 1
        return

    dfs(idx + 1, total + nums[idx], count + 1)
    dfs(idx + 1, total, count)


dfs(0, 0, 0)

print(answer)