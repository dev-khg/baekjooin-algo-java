import collections
import heapq
import sys

input = sys.stdin.readline

memo = [0] * 10001

def fibo(n: int) -> int:
    if memo[n] > 0:
        return memo[n]
    elif n == 0 or n == 1:
        return n
    memo[n] = fibo(n - 1) + fibo(n - 2)
    return memo[n]

num = int(input())
print(fibo(num))