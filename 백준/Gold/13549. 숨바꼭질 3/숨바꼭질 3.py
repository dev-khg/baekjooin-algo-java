import collections
import sys

input = sys.stdin.readline

distance = [sys.maxsize] * 100001

N, M = map(int, input().split())

distance[N] = 0

q = collections.deque()
q.append(N)

while q:
    point = q.popleft()

    jump = point * 2
    forward = point + 1
    backward = point - 1

    if 0 <= jump < 100001 and distance[jump] > distance[point]:
        distance[jump] = distance[point]
        q.append(jump)

    if 0 <= forward < 100001 and distance[forward] > distance[point] + 1:
        distance[forward] = distance[point] + 1
        q.append(forward)

    if 0 <= backward < 100001 and distance[backward] > distance[point] + 1:
        distance[backward] = distance[point] + 1
        q.append(backward)

print(distance[M])