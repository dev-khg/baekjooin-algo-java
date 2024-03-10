import collections
import heapq
import sys
from collections import deque

input = sys.stdin.readline


V, E = map(int, input().split())
K = int(input())
graph = collections.defaultdict(list)

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

dist = [sys.maxsize] * (V + 1)
min_heap = [(0, K)]
dist[K] = 0

while min_heap:
    cost, current = heapq.heappop(min_heap)

    if dist[current] < cost:
        continue

    for v, w in graph[current]:
        if dist[v] > cost + w:
            dist[v] = cost + w
            heapq.heappush(min_heap, (dist[v], v))

for i in range(1, V + 1):
    if dist[i] == sys.maxsize:
        print('INF')
    else:
        print(dist[i])

