import collections
import heapq
import sys

input = sys.stdin.readline

n, k, m = map(int, input().split())
cows = []
min_heap = []
answer = 0
spent_money = 0

for _ in range(n):
    P, C = map(int, input().split())
    cows.append((P, C))

cows.sort(key=lambda x:(x[1], x[0]))

for i in range(k):
    if cows[i][1] + spent_money <= m:
        spent_money += cows[i][1]
        answer += 1
        heapq.heappush(min_heap, (cows[i][0] - cows[i][1]))

for i in range(k, n):
    if min_heap and min_heap[0] + cows[i][1] < cows[i][0]:
        if spent_money + min_heap[0] + cows[i][1] <= m:
            spent_money += heapq.heappop(min_heap) + cows[i][1]
            answer += 1
            heapq.heappush(min_heap, (cows[i][0] - cows[i][1]))
    elif spent_money + cows[i][0] <= m:
        spent_money += cows[i][0]
        answer += 1

print(answer)
