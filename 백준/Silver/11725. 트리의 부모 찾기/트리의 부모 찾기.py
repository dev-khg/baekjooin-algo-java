import collections

N = int(input())
graph = collections.defaultdict(list)
parents = [-1] * (N + 1)
visited = [False] * (N + 1)
for _ in range(N - 1):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)


parents[1] = 0
q = collections.deque()
q.append(1)

while q:
    current = q.popleft()

    for next_node in graph[current]:
        if parents[next_node] == -1:
            parents[next_node] = current
            q.append(next_node)

for i in range(2, N + 1):
    print(parents[i])