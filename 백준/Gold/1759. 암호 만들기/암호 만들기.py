import collections
import sys

input = sys.stdin.readline

L, C = map(int, input().split())
characters = [s for s in input().split()]
moem = {'a', 'e', 'i', 'o', 'u'}
answer = []


def is_valid(s: str):
    moem_count = 0
    for c in s:
        if c in moem:
            moem_count += 1

    return moem_count >= 1 and L - moem_count >= 2


def dfs(level: int, s: int, picked: list[str]) -> None:
    if level == L:
        if is_valid(picked):
            answer.append(picked[:])
        return

    for i in range(s, C):
        picked[level] = characters[i]
        dfs(level + 1, i + 1, picked)


characters.sort()
dfs(0, 0, ['0'] * L)

for i in range(len(answer)):
    print(''.join(answer[i]))