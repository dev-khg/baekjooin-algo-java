import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

board = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
for _ in range(M):
    A, B = map(int, input().split())
    board[A].append(B)
    board[B].append(A)


def dfs(v: int) -> int:
    count = 1
    visited[v] = True

    for node in board[v]:
        if not visited[node]:
            count += dfs(node)

    return count


print(dfs(1) - 1)

