import heapq
import sys

input = sys.stdin.readline


N = int(input())
board = [[int(s) for s in input().split()] for _ in range(N)]
found_vertex = 1
visited = [False] * N
heap = []
heap.append((0, 0))
answer = 0


while found_vertex <= N:
    cost, current = heapq.heappop(heap)
    if visited[current]:
        continue
    visited[current] = True
    answer += cost
    found_vertex += 1
    for i in range(N):
        if i != current and not visited[i]:
            heapq.heappush(heap, (board[current][i], i))


print(answer)