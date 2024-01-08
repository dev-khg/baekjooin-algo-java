import collections


def should_broken(board: list[list[int]], visited: list[list[int]], y: int, x: int) -> bool:
    q = collections.deque()
    c = board[y][x]
    q.append((y, x))
    visited[y][x] = True
    counts = []
    counts.append((y, x))

    while q:
        tY, tX = q.popleft()

        for i in range(4):
            ny, nx = tY + dy[i], tX + dx[i]
            if 0 <= ny < 12 and 0 <= nx < 6 and not visited[ny][nx] and board[ny][nx] == c:
                visited[ny][nx] = True
                q.append((ny, nx))
                counts.append((ny, nx))

    if len(counts) >= 4:
        for count in counts:
            board[count[0]][count[1]] = '.'
        return True
    return False


def handle_sweep_down(board: list[list[int]]) -> None:
    for x in range(6):
        for y in range(10, -1, -1):
            for k in range(11, y, -1):
                if board[y][x] != '.' and board[k][x] == '.':
                    board[k][x], board[y][x] = board[y][x], board[k][x]




rows = 12
cols = 6

board = [['.' for _ in range(cols)] for _ in range(rows)]

for i in range(rows):
    s = input()
    for j in range(cols):
        board[i][j] = s[j]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

answer = 0
is_broken = True

while is_broken:
    is_broken = False
    visited = [[False for _ in range(cols)] for _ in range(rows)]

    for y in range(rows):
        for x in range(cols):
            if not visited[y][x] and board[y][x] != '.':
                if should_broken(board, visited, y, x):

                    is_broken = True

    if is_broken:
        answer += 1
        handle_sweep_down(board)

print(answer)