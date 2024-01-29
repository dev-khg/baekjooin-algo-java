import collections
import heapq
import sys

input = sys.stdin.readline

n = int(input())
nums = [-1] + list(map(int, input().split()))
m = int(input())
dp = [[False] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i][i] = True

for i in range(1, n):
    for j in range(1, n - i + 1):
        if nums[i + j] == nums[j]:
            if i == 1 or dp[j + 1][j + i - 1]:
                dp[j][j + i] = True


answer = []
for _ in range(m):
    A, B = map(int, input().split())
    if dp[A][B]:
        answer.append(1)
    else:
        answer.append(0)

print(*answer, sep='\n')
