
N, M = map(int,  input().split())
nums = [int(s) for s in input().split()]

sum = 0
answer = 0

lt, rt = 0, 0
for rt in range(N):
    sum += nums[rt]

    if sum == M:
        answer += 1
    while sum >= M:
        sum -= nums[lt]
        lt += 1
        if sum == M:
            answer += 1
            

print(answer)