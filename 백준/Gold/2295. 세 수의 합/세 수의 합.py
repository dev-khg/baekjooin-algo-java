import sys

input = sys.stdin.readline

N = int(input())

nums = [int(input()) for _ in range(N)]
nums.sort()

sum_set = set()

for i in nums:
    for j in nums:
        sum_set.add(i + j)


def solve():
    for i in range(N - 1, -1, -1):
        for j in range(i + 1):
            if nums[i] - nums[j] in sum_set:
                return nums[i]

print(solve())