import collections
import sys

input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(9)]
blanks = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            blanks.append((i, j))


def is_contain_square(y: int, x: int, num: int):
    for i in range(y, y + 3):
        for j in range(x, x + 3):
            if num == board[i][j]:
                return False
    return True


def is_contain_row(num: int, row: int):
    for i in range(9):
        if board[row][i] == num:
            return False
    return True


def is_contain_col(num: int, col: int):
    for i in range(9):
        if board[i][col] == num:
            return False
    return True


def dfs(L: int):
    if L == len(blanks):
        for nums in board:
            print(*nums)
        exit()

    y, x = blanks[L]
    for num in range(1, 10):
        if is_contain_row(num, y) and is_contain_col(num, x) and is_contain_square(y // 3 * 3, x // 3 * 3, num):
            board[y][x] = num
            dfs(L + 1)
            board[y][x] = 0


dfs(0)