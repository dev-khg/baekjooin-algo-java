import copy
import sys


input = sys.stdin.readline

N = int(input())
board = [[int(s) for s in input().split()] for _ in range(N)]
answer = 0


def slide_up(graph: list[list[int]]) -> list[list[int]]:
    temp = copy.deepcopy(graph)

    for i in range(N):
        index = 0
        block = 0
        for j in range(N):
            if temp[j][i] != 0:
                if block == temp[j][i]:
                    temp[index - 1][i] = block * 2
                    block = 0
                    temp[j][i] = 0
                else:
                    block = temp[j][i]
                    temp[j][i] = 0
                    temp[index][i] = block
                    index += 1
    return temp


def slide_down(graph: list[list[int]]) -> list[list[int]]:
    temp = copy.deepcopy(graph)

    for i in range(N):
        index = N - 1
        block = 0
        for j in range(N - 1, -1, -1):
            if temp[j][i] != 0:
                if block == temp[j][i]:
                    temp[index + 1][i] = block * 2
                    block = 0
                    temp[j][i] = 0
                else:
                    block = temp[j][i]
                    temp[j][i] = 0
                    temp[index][i] = block
                    index -= 1
    return temp


def slide_left(graph: list[list[int]]) -> list[list[int]]:
    temp = copy.deepcopy(graph)

    for i in range(N):
        index = 0
        block = 0
        for j in range(N):
            if temp[i][j] != 0:
                if block == temp[i][j]:
                    temp[i][index - 1] = block * 2
                    block = 0
                    temp[i][j] = 0
                else:
                    block = temp[i][j]
                    temp[i][j] = 0
                    temp[i][index] = block
                    index += 1
    return temp


def slide_right(graph: list[list[int]]) -> list[list[int]]:
    temp = copy.deepcopy(graph)

    for i in range(len(temp)):
        index = N - 1
        block = 0
        for j in range(N - 1, -1, -1):
            if temp[i][j] != 0:
                if block == temp[i][j]:
                    temp[i][index + 1] = block * 2
                    block = 0
                    temp[i][j] = 0
                else:
                    block = temp[i][j]
                    temp[i][j] = 0
                    temp[i][index] = block
                    index -= 1
    return temp


def get_max(graph: list[list[int]]) -> int:
    max_value = 0
    for i in range(len(graph)):
        for j in range(len(graph)):
            max_value = max(max_value, graph[i][j])
    return max_value


def dfs(level: int, graph: list[list[int]]) -> None:
    global answer
    if level > 4:
        answer = max(get_max(graph), answer)
        return

    dfs(level + 1, slide_left(graph))
    dfs(level + 1, slide_right(graph))
    dfs(level + 1, slide_up(graph))
    dfs(level + 1, slide_down(graph))


dfs(0, board)
print(answer)