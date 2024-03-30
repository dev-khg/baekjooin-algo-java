import collections
import heapq
import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    nums = list(map(int, input().split()))

    rMax = nums[-1]
    answer = 0
    for i in range(len(nums) - 2, -1, -1):
        answer += max(0, rMax - nums[i])
        rMax = max(rMax, nums[i])

    print(answer)