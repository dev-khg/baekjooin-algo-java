import collections
import heapq
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
answer = 0
positive_nums = []
negative_nums = []

for i in range(len(nums)):
    if nums[i] > 0:
        positive_nums.append(nums[i])
    else:
        negative_nums.append(nums[i])

positive_nums.sort(reverse=True)
negative_nums.sort()

tmp = 0
if positive_nums:
    tmp = positive_nums[0]
if negative_nums:
    tmp = max(tmp, abs(negative_nums[0]))

for i in range(0, len(negative_nums), M):
    answer += abs(negative_nums[i]) * 2
for i in range(0, len(positive_nums), M):
    answer += positive_nums[i] * 2


print(answer - tmp)