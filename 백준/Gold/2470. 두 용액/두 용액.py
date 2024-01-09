import sys

N = int(input())
nums = [int(s) for s in input().split()]
nums.sort()

answer = [0, 0]
min_diff = sys.maxsize

lt, rt = 0, N - 1

while lt < rt:
    sum = nums[lt] + nums[rt]

    if abs(sum) < min_diff:
        min_diff = abs(sum)
        answer[0] = nums[lt]
        answer[1] = nums[rt]

    if sum > 0:
        rt -= 1
    else:
        lt += 1

print(*answer)

