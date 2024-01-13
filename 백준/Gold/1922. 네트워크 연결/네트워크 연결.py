import collections
import heapq
import sys

input = sys.stdin.readline

class DisjointSet:
    def __init__(self, n):
        self.parents = list(range(n + 1))


    def find(self, v):
        if self.parents[v] == v: return v
        self.parents[v] = self.find(self.parents[v])
        return self.parents[v]

    def union(self, v1, v2) -> bool:
        root_v1 = self.find(v1)
        root_v2 = self.find(v2)

        if root_v1 != root_v2:
            self.parents[root_v1] = root_v2
            return True
        return False


N = int(input())
M = int(input())
disjoint_set = DisjointSet(N)
answer = 0
selected = 0
min_heap = []

for _ in range(M):
    v1, v2, cost = map(int, input().split())
    min_heap.append((cost, v1, v2))


heapq.heapify(min_heap)

while selected < N - 1:
    temp = heapq.heappop(min_heap)
    cost, v1, v2 = temp[0], temp[1], temp[2]
    if disjoint_set.union(v1, v2):
        answer += cost
        selected += 1

print(answer)