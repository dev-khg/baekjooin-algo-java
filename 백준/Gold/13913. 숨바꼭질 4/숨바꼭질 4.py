import collections
import sys

input = sys.stdin.readline

parent = [-1] * 100001
N, M = map(int, input().split())

def bfs(start: int, end: int):
    global parent
    q = collections.deque()
    q.append(start)
    result = []

    while q:
        current = q.popleft()

        if current == end:
            root = current
            while root != start:
                result.append(root)
                root = parent[root]
            result.append(start)
            return result

        jump = current * 2

        if 0 <= jump <= 100000 and parent[jump] == -1:
            parent[jump] = current
            q.append(jump)

        forward = current + 1
        if 0 <= forward <= 100000 and parent[forward] == -1:
            parent[forward] = current
            q.append(forward)

        backward = current - 1
        if 0 <= backward <= 100000 and parent[backward] == -1:
            parent[backward] = current
            q.append(backward)


result = bfs(N, M)
print(len(result) - 1)
print(*result[::-1])