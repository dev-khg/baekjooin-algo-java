import collections
import sys

input = sys.stdin.readline


T = int(input())
answer = []
count = 0
sum_numbers = [1, 2, 3]


def dfs(sum: int, target: int) -> None:
    global count, answer

    if sum > target:
        return
    if sum == target:
        count += 1
        return

    for number in sum_numbers:
        dfs(sum + number, target)


for _ in range(T):
    count = 0
    target = int(input())
    dfs(0, target)
    answer.append(count)


print('\n'.join(map(str, answer)))