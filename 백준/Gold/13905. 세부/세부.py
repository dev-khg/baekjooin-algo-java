import heapq
import sys

input = sys.stdin.readline


def find(v: int) -> int:
    if parents[v] != v:
        parents[v] = find(parents[v])
    return parents[v]


def union(root_x: int, root_y: int):
    if root_x < root_y:
        parents[root_y] = root_x
    elif root_x > root_y:
        parents[root_x] = root_y


n, m = map(int, input().split())
S, E = map(int, input().split())
parents = list(range(n + 1))
heap = []
for _ in range(m):
    A, B, cost = map(int, input().split())
    heapq.heappush(heap, (-cost, A, B))

answer = 0
while heap:
    cost, A, B = heapq.heappop(heap)

    fa = find(A)
    fb = find(B)

    if fa != fb:
        union(fa, fb)

        if find(S) == find(E):
            answer = -cost
            break

print(answer)