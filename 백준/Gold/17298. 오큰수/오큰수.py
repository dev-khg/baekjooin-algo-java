

N = int(input())
A = [int(s) for s in input().split()]
answer = [-1] * N
stack = []
for i in range(N - 1, -1, -1):
    while stack and A[i] >= A[stack[-1]]:
        stack.pop()
    if stack and A[stack[-1]] > A[i]:
        answer[i] = A[stack[-1]]
    stack.append(i)

print(*answer)