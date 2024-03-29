import bisect
import sys

input = sys.stdin.readline

n, c = map(int, input().split())
w = list(map(int, input().split()))

a_w = w[:n // 2]
b_w = w[n // 2:]
a_sum = []
b_sum = []


def brute_force(L: int, total: int, weights:list[int], sum_arr: list[int]) -> None:
    if L == len(weights):
        sum_arr.append(total)
        return

    brute_force(L + 1, total, weights, sum_arr)
    brute_force(L + 1, total + weights[L], weights, sum_arr)


brute_force(0, 0, a_w, a_sum)
brute_force(0, 0, b_w, b_sum)
b_sum.sort()
answer = 0

for a in a_sum:
    target = c - a
    if target < 0:
        continue

    lt, rt = 0, len(b_sum) - 1
    while lt <= rt:
        mid = (lt + rt) // 2
        if b_sum[mid] <= target:
            lt = mid + 1
        else:
            rt = mid - 1

    answer += lt

print(answer)