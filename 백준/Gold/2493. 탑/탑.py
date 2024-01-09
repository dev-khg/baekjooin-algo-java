import heapq


N = int(input())
tops = [int(s) for s in input().split()]
answer = [0] * N
stack = []

for i in range(N - 1, -1, -1):
    while stack and tops[stack[-1]] < tops[i]:
        answer[stack.pop()] = i + 1
    stack.append(i)

print(' '.join(map(str, answer)))