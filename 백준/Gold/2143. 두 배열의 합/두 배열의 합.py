import collections
import sys

input = sys.stdin.readline

T = int(input())

N = int(input())
A = [int(s) for s in input().split()]
M = int(input())
B = [int(s) for s in input().split()]

result = 0
c = collections.defaultdict(int)

for s in range(N):
    for e in range(s, N):
        c[sum(A[s:e+1])] += 1

for s in range(M):
    for e in range(s, M):
        result += c[T - sum(B[s:e+1])]

print(result)