import sys

input = sys.stdin.readline

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
dp = [[-1] * n for _ in range(m)]

def solve(y: int, x: int):
    global m, n
    if y == m - 1 and x == n - 1:
        return 1

    if dp[y][x] != -1:
        return dp[y][x]

    total = 0

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < m and 0 <= nx < n and board[ny][nx] < board[y][x]:
            total += solve(ny, nx)

    dp[y][x] = total
    return dp[y][x]

print(solve(0, 0))