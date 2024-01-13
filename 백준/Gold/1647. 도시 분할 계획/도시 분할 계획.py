import sys

input = sys.stdin.readline

n, m = map(int, input().split())
parents = list(range(n + 1))


def find(v) -> int:
    if parents[v] == v: return v
    parents[v] = find(parents[v])
    return parents[v]


def union(root_x, root_y):
    if root_x > root_y:
        parents[root_x] = root_y
    else:
        parents[root_y] = root_x

roads = []
for _ in range(m):
    A, B, cost = map(int, input().split())
    roads.append((A, B, cost))

roads.sort(reverse=True, key=lambda x:(x[2]))
connected = 0
costs = []

while connected < n - 1:
    A, B, cost = roads.pop()

    fa = find(A)
    fb = find(B)

    if fa != fb:
        union(fa, fb)
        connected += 1
        costs.append(cost)


print(sum(costs) - max(costs))