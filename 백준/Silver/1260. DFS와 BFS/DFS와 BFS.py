import collections
import sys

input = sys.stdin.readline


N, M, V = map(int, input().split())
visited = [False] * (N + 1)
graph = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
dfs_answer = []
bfs_answer = []

for _ in range(M):
    A, B = map(int, input().split())
    graph[A][B] = 1
    graph[B][A] = 1


def dfs(current: int):
    visited[current] = True
    dfs_answer.append(current)

    for next in range(1, N + 1):
        if not visited[next] and graph[current][next] == 1:
            dfs(next)


def bfs(node: int):
    visited[node] = True
    q = collections.deque()
    q.append(node)

    while q:
        current = q.popleft()
        bfs_answer.append(current)

        for next in range(1, N + 1):
            if not visited[next] and graph[current][next] == 1:
                visited[next] = True
                q.append(next)


dfs(V)
visited = [False] * (N + 1)
bfs(V)
print(*dfs_answer)
print(*bfs_answer)