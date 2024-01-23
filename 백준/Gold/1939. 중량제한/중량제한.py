import collections
import heapq
import sys

input = sys.stdin.readline


class UnionSet:
    def __init__(self, N):
        self.parents = list(range(N + 1))

    def find(self, v):
        if self.parents[v] == v:
            return v
        self.parents[v] = self.find(self.find(self.parents[v]))
        return self.parents[v]

    def union(self, root_v1, root_v2):
        self.parents[root_v1] = root_v2


N, M = map(int, input().split())

max_heap = []
for _ in range(M):
    A, B, C = map(int, input().split())
    max_heap.append((A, B, C))
S, E = map(int, input().split())
max_heap.sort(reverse=True, key=lambda x:(x[2]))
ptr = 0
union_set = UnionSet(N)
answer = 0
while max_heap:
    v1, v2, cost = max_heap[ptr]
    ptr += 1

    root_v1,root_v2 = union_set.find(v1), union_set.find(v2)
    if root_v1 != root_v2:
        union_set.union(root_v1, root_v2)

        if union_set.find(S) == union_set.find(E):
            answer = cost
            break

print(cost)