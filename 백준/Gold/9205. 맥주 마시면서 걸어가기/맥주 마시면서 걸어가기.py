import collections
import sys

input = sys.stdin.readline

t = int(input())

ey, ex = 0, 0

def is_possible(visited: list[bool], stores: list[int], cy, cx) -> bool:
    global ey, ex
    q = collections.deque()
    q.append((cy, cx))

    while q:
        ny, nx = q.popleft()

        if abs(ny - ey) + abs(nx - ex) <= 1000:
            return True

        for i in range(n):
            if not visited[i] and abs(ny - stores[i][0]) + abs(nx - stores[i][1]) <= 1000:
                visited[i] = True
                q.append((stores[i][0], stores[i][1]))

    return False

answer = []

for _ in range(t):
    n = int(input())
    store = []
    cy, cx = map(int, input().split())

    for _ in range(n):
        y, x = map(int, input().split())
        store.append((y, x))
    ey, ex = map(int, input().split())
    visited = [False] * n

    if is_possible(visited, store, cy, cx):
        answer.append("happy")
    else:
        answer.append("sad")

print(*answer, sep='\n')
