import collections
import heapq
import sys

input = sys.stdin.readline

n = int(input())
RED = 0
GREEN = 1
BLUE = 2

board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(3)] for _ in range(n)]

dp[0][RED] = board[0][RED]
dp[0][GREEN] = board[0][GREEN]
dp[0][BLUE] = board[0][BLUE]

for i in range(1, n):
    dp[i][RED] = min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + board[i][RED]
    dp[i][GREEN] = min(dp[i - 1][RED], dp[i - 1][BLUE]) + board[i][GREEN]
    dp[i][BLUE] = min(dp[i - 1][RED], dp[i - 1][GREEN]) + board[i][BLUE]

print(min(dp[n - 1][RED], dp[n - 1][GREEN], dp[n - 1][BLUE]))
