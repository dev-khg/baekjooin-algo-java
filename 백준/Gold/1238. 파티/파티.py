import collections
import heapq
import sys


input = sys.stdin.readline


N, M, X = map(int, input().split())

graph = collections.defaultdict(list)
reverse_graph = collections.defaultdict(list)

for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    reverse_graph[v].append((u, w))


def dijkstra_set(board) -> list[int]:
    global N, X

    dist = [sys.maxsize] * (N + 1)
    dist[X] = 0
    min_heap = [(0, X)]

    while min_heap:
        cost, current = heapq.heappop(min_heap)

        if cost > dist[current]:
            continue

        for next_node, next_cost in board[current]:
            if dist[next_node] > next_cost + cost:
                dist[next_node] = next_cost + cost
                heapq.heappush(min_heap, (dist[next_node], next_node))

    return dist


distance = dijkstra_set(graph)
reverse_distance = dijkstra_set(reverse_graph)
answer = 0
for i in range(1, N + 1):
    answer = max(answer, distance[i] + reverse_distance[i])

print(answer)

