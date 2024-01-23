import collections
import heapq
import sys

input = sys.stdin.readline

N, M, X = map(int, input().split())

graph = collections.defaultdict(list)
reverse_graph = collections.defaultdict(list)

for _ in range(M):
    A, B, cost = map(int, input().split())
    graph[A].append((B, cost))
    reverse_graph[B].append((A, cost))


def calculate_distance(board, start):
    global N
    min_heap = []
    distance = [sys.maxsize] * (N + 1)
    min_heap.append((0, start))
    distance[start] = 0
    while min_heap:
        cost, current = heapq.heappop(min_heap)
        if distance[current] < cost:
            continue
        distance[current] = cost

        for node, next_cost in board[current]:
            if distance[node] > distance[current] + next_cost:
                distance[node] = distance[current] + next_cost
                heapq.heappush(min_heap, (distance[node], node))

    return distance


go_distance = calculate_distance(graph, X)
back_distance = calculate_distance(reverse_graph, X)

answer = 0
for i in range(1, len(go_distance)):
    answer = max(go_distance[i] + back_distance[i], answer)

print(answer)