import sys

n, m = map(int, input().split())

arr = [int(s) for s in input().split()]



total = 0
answer = sys.maxsize
sum = 0
lt, rt = 0, 0

while lt <= rt and rt < n:
    sum += arr[rt]
    rt += 1

    while sum >= m:
        answer = min(answer, rt - lt)
        sum -= arr[lt]
        lt += 1

print(answer if answer != sys.maxsize else 0)