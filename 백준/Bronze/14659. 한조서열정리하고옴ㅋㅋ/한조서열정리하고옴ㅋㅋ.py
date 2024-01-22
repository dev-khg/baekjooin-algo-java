import collections
import heapq
import sys

input = sys.stdin.readline

n = int(input())
heights = list(map(int, input().split()))

current_height = heights[0]
ptr = 1
count = 0
answer = 0
while ptr < n:
    if heights[ptr] < current_height:
        count += 1
    else:
        current_height = heights[ptr]
        count = 0
    answer = max(answer, count)
    ptr += 1

print(answer)