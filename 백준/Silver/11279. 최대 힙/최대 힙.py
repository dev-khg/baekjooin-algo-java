import heapq
import sys
import time

input = sys.stdin.readline
N = int(input())
heap = []
answer = []

for _ in range(N):
    num = int(input())
    if num == 0:
        if not heap:
            answer.append(0)
        else:
            answer.append(-heapq.heappop(heap))
    else:
        heapq.heappush(heap, -num)

print('\n'.join(map(str, answer)))