import collections
import heapq
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

graph = collections.defaultdict(list)
visited = [False] * 1001

for _ in range(M):
    A, B, cost = map(int, input().split())
    graph[A].append((B, cost))
    graph[B].append((A, cost))



min_heap = []
heapq.heappush(min_heap, (0, 1))
answer = 0

while min_heap:
    cost, v = heapq.heappop(min_heap)
    if visited[v]:
        continue
    visited[v] = True
    answer += cost
    for next_vertex, cost in graph[v]:
        if not visited[next_vertex]:
            heapq.heappush(min_heap, (cost, next_vertex))

print(answer)
