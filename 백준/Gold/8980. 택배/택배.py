import collections
import heapq
import sys

input = sys.stdin.readline

N, C = map(int, input().split()) # N 마을의 수 / C : 개수 제한
M = int(input())
boxes = []
for _ in range(M):
    sender, receiver, box_count = map(int, input().split())
    boxes.append((sender, receiver, box_count))
boxes.sort(key=lambda x:(x[1]))

capacity = [C] * N
answer = 0
for sender, receiver, box_count in boxes:
    limit = C
    for i in range(sender, receiver):
        memo = min(capacity[i], box_count)
        if limit > memo:
            limit = memo

    for i in range(sender, receiver):
        capacity[i] -= limit

    answer += limit

print(answer)