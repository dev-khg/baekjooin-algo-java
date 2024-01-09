import collections

N, K = map(int, input().split())

nums = [int(s) for s in input().split()]
count = 0
lt, rt = 0, 0
answer = 0

for rt in range(N):
    if nums[rt] % 2 == 1:
        count += 1

    while count > K:
        if nums[lt] % 2 == 1:
            count -= 1
        lt += 1

    answer = max(answer, rt - lt + 1 - count)

print(answer)