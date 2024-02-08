import collections


n, m = map(int, input().split())

board = []

for i in range(n):
    board.append(list(map(int, input().split())))

def dfs(board: [list[list[int]]], y: int, x: int) -> int:
    deque = collections.deque()
    count = 1
    board[y][x] = 0
    deque.append([y, x])
    dy = [-1, 1,0, 0]
    dx = [0,0,-1,1]
    while deque:
        node = deque.popleft()
        y, x = node[0], node[1]

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny >= 0 and nx >= 0 and ny < n and nx < m and board[ny][nx] == 1:
                board[ny][nx] = 0
                count += 1
                deque.append([ny, nx])
    return count

max_area, count = 0, 0

for y in range(n):
    for x in range(m):
        if board[y][x] == 1:
            max_area = max(max_area, dfs(board, y, x))
            count += 1
print(count)
print(max_area)