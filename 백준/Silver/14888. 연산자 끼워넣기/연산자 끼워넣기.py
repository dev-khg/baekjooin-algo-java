import collections
import sys

input = sys.stdin.readline

plus, minus, multiply, divide = 0, 1, 2, 3

N = int(input())
nums = list(map(int, input().split()))
op_cnt = list(map(int, input().split()))
max_answer = -1000000001
min_answer = 1000000000


def dfs(L: int, total: int):
    global N, max_answer, min_answer

    if L == N:
        max_answer = max(total, max_answer)
        min_answer = min(total, min_answer)
        return

    for i in range(4):
        if op_cnt[i] > 0:
            op_cnt[i] -= 1
            if i == plus:
                dfs(L + 1, total + nums[L])
            elif i == minus:
                dfs(L + 1, total - nums[L])
            elif i == multiply:
                dfs(L + 1, total * nums[L])
            else:
                dfs(L + 1, int(total / nums[L]))
            op_cnt[i] += 1


dfs(1, nums[0])
print(max_answer, min_answer, sep='\n')