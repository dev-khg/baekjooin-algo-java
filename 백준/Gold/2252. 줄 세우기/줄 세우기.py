import collections
import heapq
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

graph = collections.defaultdict(list)
in_degree = [0] * (n + 1)
q = collections.deque()
answer = []

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    in_degree[b] += 1

for i in range(1, n + 1):
    if in_degree[i] == 0:
        q.append(i)

while q:
    node = q.popleft()
    answer.append(node)
    for i in graph[node]:
        in_degree[i] -= 1
        if in_degree[i] == 0:
            q.append(i)

print(*answer)