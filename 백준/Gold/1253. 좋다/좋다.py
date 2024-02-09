import collections
import heapq
import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

nums.sort()
answer = 0

for i in range(N):
    lt, rt = 0, N - 1

    while lt < rt:
        if lt == i:
            lt += 1
            continue
        elif rt == i:
            rt -= 1
            continue

        hap = nums[lt] + nums[rt]
        if nums[i] > hap:
            lt += 1
        elif nums[i] < hap:
            rt -= 1
        else:
            answer += 1
            break


print(answer)