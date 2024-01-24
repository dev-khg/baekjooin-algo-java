import collections
import heapq
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

for i in range(len(nums)):
    nums[i] = abs(nums[i] - M)

tmp = nums[0]

def gcd(a, b):
    r = a % b
    if r == 0:
        return b
    return gcd(b, r)


for i in range(1, len(nums)):
    tmp = gcd(tmp, nums[i])

print(tmp)