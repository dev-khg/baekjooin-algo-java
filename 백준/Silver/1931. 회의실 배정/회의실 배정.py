import collections
import heapq
import sys

input = sys.stdin.readline

N = int(input())
schedules = [list(map(int, input().split())) for _ in range(N)]
answer = 0
schedules.sort(key=lambda x:(x[1], x[0]))
last_end = 0

for start, end in schedules:
    if last_end <= start:
        answer += 1
        last_end = end


print(answer)