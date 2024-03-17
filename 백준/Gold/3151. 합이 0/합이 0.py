import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()


answer = 0
for i in range(N - 2):
    num, lt, rt = nums[i], i + 1, N - 1

    while lt < rt:
        total = num + nums[lt] + nums[rt]

        if total == 0:
            lCnt = 1
            rCnt = 1
            if nums[lt] == nums[rt]:
                n = rt - lt + 1
                answer += n * (n - 1) // 2
                break

            while nums[lt] == nums[lt + 1]:
                lCnt += 1
                lt += 1
            while nums[rt] == nums[rt - 1]:
                rCnt += 1
                rt -= 1

            answer += lCnt * rCnt

        if total > 0:
            rt -= 1
        else:
            lt += 1


print(answer)