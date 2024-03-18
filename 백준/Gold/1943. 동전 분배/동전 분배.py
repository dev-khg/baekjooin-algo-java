import collections
import heapq
import itertools
import sys


input = sys.stdin.readline

answer = []
for _ in range(3):
    total = 0
    coins = []
    for _ in range(int(input())):
        money, count = map(int, input().split())
        total += money * count
        coins.append([money, count])

    if total % 2 == 1:
        answer.append(0)
        continue

    total //= 2
    dp = [1] + [0] * (total)

    for i in range(len(coins)):
        money, count = coins[i]

        for j in range(total, money - 1, -1):
            if dp[j - money]:
                for k in range(count):
                    if j + money * k <= total:
                        dp[j + money * k] = 1

    answer.append(dp[-1])

print(*answer, sep='\n')

