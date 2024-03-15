import collections
import heapq
import itertools
import sys


input = sys.stdin.readline

n = int(input())
m = int(input())

visited = [-1] * (n + 1)
distance = [sys.maxsize] * (n + 1)
graph = collections.defaultdict(list)

for _ in range(m):
    v, u, w = map(int, input().split())
    graph[v].append((u, w))

start, end = map(int, input().split())

min_heap = [(0, start)]
distance[start] = 0

while min_heap:
    cost, u = heapq.heappop(min_heap)

    if cost > distance[u]:
        continue

    for next_node, next_cost in graph[u]:
        if distance[next_node] > distance[u] + next_cost:
            distance[next_node] = distance[u] + next_cost
            visited[next_node] = u
            heapq.heappush(min_heap, (distance[next_node], next_node))


tracker = [end]
current = end
while visited[current] != start:
    current = visited[current]
    tracker.append(current)
tracker.append(start)
tracker.reverse()
print(distance[end])
print(len(tracker))
print(*tracker, sep=' ')