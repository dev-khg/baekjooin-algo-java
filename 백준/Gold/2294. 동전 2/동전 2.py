import collections
import heapq
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

coins = [int(input()) for _ in range(n)]

dp = [sys.maxsize] * (k + 1)
dp[0] = 0
answer = -1

for i in range(n):
    for j in range(coins[i], k + 1):
        dp[j] = min(dp[j - coins[i]] + 1, dp[j])


if dp[k] == sys.maxsize:
    print(-1)
else:
    print(dp[k])