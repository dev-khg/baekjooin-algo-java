import copy
import sys


def calculate_empty_space(graph: [list[list[int]]]) -> int:
    count = 0
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == 0:
                count += 1
    return count


def fill(graph: [list[list[int]]], y: int, x: int, move: [int]) -> None:
    while True:
        ny, nx = y + move[0], x + move[1]
        if 0 <= ny < len(graph) and 0 <= nx < len(graph[0]) and graph[ny][nx] != 6:
            graph[ny][nx] = 7
            y, x = ny, nx
        else:
            break


def dfs(level: int, graph: list[list[int]]) -> None:
    global answer, empty_space, cctvs, cctv_directions, move_direction
    if level == len(cctvs):
        answer = min(answer, calculate_empty_space(graph))
        return

    y, x, cctv_type = cctvs[level]

    for cctv_direction in cctv_directions[cctv_type]:
        temp = copy.deepcopy(graph)
        if cctv_direction & left > 0:
            fill(temp, y, x, move_direction[left])
        if cctv_direction & right > 0:
            fill(temp, y, x, move_direction[right])
        if cctv_direction & up > 0:
            fill(temp, y, x, move_direction[up])
        if cctv_direction & down > 0:
            fill(temp, y, x, move_direction[down])
        dfs(level + 1, temp)


left, right, up, down = (1 << 0), (1 << 1), (1 << 2), (1 << 3)
all = left | right | up | down
cctv_directions = [
    [],
    [left, right, up, down],
    [left | right, up | down],
    [left | up, left | down, right | up, right | down],
    [all ^ left, all ^ right, all ^ up, all ^ down],
    [all]
]
move_direction = {
    left: [0, -1],
    right: [0, 1],
    up: [1, 0],
    down: [-1, 0],
}
input = sys.stdin.readline

N, M = map(int, input().split())
board = [[int(s) for s in input().split()] for _ in range(N)]
cctvs = []
empty_space = 0

answer = 64


for i in range(len(board)):
    for j in range(len(board[0])):
        if board[i][j] == 0:
            empty_space += 1
        elif board[i][j] != 6:
            cctvs.append((i, j, board[i][j]))


dfs(0, board)
print(answer)