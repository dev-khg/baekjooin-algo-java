import collections
import copy
import sys

input = sys.stdin.readline

knight_jump = [
    [-2, 1], [-1, 2], [1, 2], [2, 1],
    [-2, -1], [-1, -2], [1, -2], [2, -1],
]


T = int(input())
answer = []
for _ in range(T):
    l = int(input())
    board = [[0 for _ in range(l)] for _ in range(l)]
    current_y, current_x = map(int, input().split())
    target_y, target_x = map(int, input().split())
    q = collections.deque()
    q.append((current_y, current_x))
    while q:
        y, x = q.popleft()

        if y == target_y and x == target_x:
            if target_y == current_y and target_x == current_x:
                answer.append(0)
            else:
                answer.append(board[y][x])
            break

        for jump in knight_jump:
            ny, nx = y + jump[0], x + jump[1]

            if 0 <= ny < l and 0 <= nx < l and board[ny][nx] == 0:
                board[ny][nx] = board[y][x] + 1
                q.append((ny, nx))


print(*answer)