import bisect
import collections
import heapq
import sys

input = sys.stdin.readline

N, K, M = map(int, input().split())
cows = []
min_heap = []
answer = 0
total = 0

for _ in range(N):
    P, C = map(int, input().split())
    cows.append((P, C))

cows.sort(key=lambda x:(x[1], x[0]))


for i in range(K):
    if cows[i][1] + total <= M:
        total += cows[i][1]
        answer += 1
        heapq.heappush(min_heap, cows[i][0] - cows[i][1])


for i in range(K, N):
    if min_heap and min_heap[0] + cows[i][1] < cows[i][0]:
        if total + min_heap[0] + cows[i][1] <= M:
            total += heapq.heappop(min_heap) + cows[i][1]
            answer += 1
            heapq.heappush(min_heap, cows[i][0] - cows[i][1])
    else:
        if total + cows[i][0] <= M:
            total += cows[i][0]
            answer += 1


print(answer)