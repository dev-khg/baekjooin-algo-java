import collections
import itertools


def calculate_s_count(picked) -> int:
    count = 0
    for pick in picked:
        if pick[2] == 'S':
            count += 1
    return count


def is_connected(picked) -> bool:
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    visited = [[False for _ in range(7)] for _ in range(7)]

    for pick in picked:
        visited[pick[0]][pick[1]] = True

    q = collections.deque()
    q.append((picked[0][0], picked[0][1]))
    count = 1
    visited[picked[0][0]][picked[0][1]] = False

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < 7 and 0 <= nx < 7 and visited[ny][nx]:
                count += 1
                visited[ny][nx] = False
                q.append((ny, nx))

    return count == 7


combi = []

for i in range(5):
    cols = input()
    for j in range(5):
        combi.append((i, j, cols[j]))

count = 0
answer = 0
for picked in itertools.combinations(combi, 7):
    if calculate_s_count(picked) >= 4 and is_connected(picked):
        answer += 1


print(answer)

