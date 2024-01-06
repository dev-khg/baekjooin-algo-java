import heapq
import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    k = int(input())
    visited = [False] * 1_000_001
    min_heap, max_heap = [], []

    for idx in range(k):
        c, n = input().split()

        if c == 'I':
            value = int(n)
            heapq.heappush(min_heap, (value, idx))
            heapq.heappush(max_heap, (-value, idx))
            visited[idx] = True
            continue

        if n == '-1':
            while min_heap and not visited[min_heap[0][1]]:
                heapq.heappop(min_heap)
            if min_heap:
                visited[heapq.heappop(min_heap)[1]] = False
        else:
            while max_heap and not visited[max_heap[0][1]]:
                heapq.heappop(max_heap)
            if max_heap:
                visited[heapq.heappop(max_heap)[1]] = False

        while min_heap and not visited[min_heap[0][1]]:
            heapq.heappop(min_heap)
        while max_heap and not visited[max_heap[0][1]]:
            heapq.heappop(max_heap)

    if min_heap and max_heap:
        print(-heapq.heappop(max_heap)[0], heapq.heappop(min_heap)[0])
    else:
        print('EMPTY')