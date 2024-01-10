import sys

input = sys.stdin.readline

N = int(input())
board = [[0 for _ in range(N)] for _ in range(N)]
answer = []

dy = [-1, 1, 0, 0]
dx = [0, 0, 1, -1]


def dfs(y: int, x: int) -> int:
    count = 1
    board[y][x] = 0

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == 1:
            count += dfs(ny, nx)

    return count


for i in range(N):
    s = input()
    for j in range(N):
        board[i][j] = int(s[j])


for y in range(N):
    for x in range(N):
        if board[y][x] == 1:
            answer.append(dfs(y, x))

answer.sort()
print(len(answer))
print(*answer)