import heapq
import sys

input = sys.stdin.readline

N, K = map(int, input().split())

jewels = []
bags = []

for _ in range(N):
    M, V = map(int, input().split())
    jewels.append((M, V))

for _ in range(K):
    bags.append(int(input()))

answer = 0
jewels.sort()
bags.sort()
max_heap = []
pointer = 0
jewel_len = len(jewels)
for bag in bags:
    while pointer < jewel_len and jewels[pointer][0] <= bag:
        heapq.heappush(max_heap, -jewels[pointer][1])
        pointer += 1
    if max_heap:
        answer += heapq.heappop(max_heap)

print(-answer)
