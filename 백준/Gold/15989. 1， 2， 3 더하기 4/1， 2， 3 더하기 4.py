import collections
import heapq
import sys

input = sys.stdin.readline

dp = [[0] * 4 for _ in range(10001)]

dp[1][1] = 1
dp[2][1] = 1
dp[2][2] = 1
dp[3][1] = 1
dp[3][2] = 1
dp[3][3] = 1

for i in range(4, 10001):
    dp[i][1] = dp[i - 1][1]
    dp[i][2] = dp[i - 2][2] + dp[i - 2][1]
    dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]

T = int(input())

answer = []
for _ in range(T):
    num = int(input())
    answer.append(dp[num][1] + dp[num][2] + dp[num][3])

print(*answer, sep='\n')
