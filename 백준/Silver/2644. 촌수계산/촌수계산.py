import collections
import heapq
import sys

input = sys.stdin.readline

N = int(input())
A, B = map(int, input().split())
M = int(input())
graph = collections.defaultdict(list)
visited = [False] * (N + 1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

q = collections.deque()
q.append((A, 0))
answer = -1

while q:
    node, cost = q.popleft()
    if visited[node]:
        continue
    visited[node] = True

    if node == B:
        answer = cost
        break

    for next_node in graph[node]:
        if not visited[next_node]:
            q.append((next_node, cost + 1))


print(answer)