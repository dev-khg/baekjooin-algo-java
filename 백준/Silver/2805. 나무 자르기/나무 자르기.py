import sys

def get_trees(arr: list[int], height: int) -> int:
    sum = 0
    for n in arr:
        sum += max(0, n - height)
    return sum

input = sys.stdin.readline

N, M = map(int, input().split())
trees = [int(s) for s in input().split()]
trees.sort()

lt, rt = 1, trees[-1]

answer = 0

while lt <= rt:
    mid = (lt + rt) // 2

    if get_trees(trees, mid) >= M:
        lt = mid + 1
        answer = mid
    else:
        rt = mid - 1

print(answer)