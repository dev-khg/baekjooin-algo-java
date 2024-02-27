import sys

input = sys.stdin.readline

memo = [0] * 100_001

N, K = map(int, input().split())
a = list(map(int, input().split()))

lt = 0
answer = 0

for rt in range(N):
    memo[a[rt]] += 1

    while memo[a[rt]] > K:
        memo[a[lt]] -= 1
        lt += 1

    answer = max(answer, rt - lt + 1)

print(answer)