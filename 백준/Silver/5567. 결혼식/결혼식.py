import collections
import sys

input = sys.stdin.readline


graph = collections.defaultdict(list)

n = int(input())
m = int(input())

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)
q = [(1, 0)]

while q:
    node, cost = q.pop()

    if cost > 2:
        continue

    visited[node] = True

    for next_node in graph[node]:
        if not visited[next_node]:
            q.append((next_node, cost + 1))

print(visited.count(True) - 1)

