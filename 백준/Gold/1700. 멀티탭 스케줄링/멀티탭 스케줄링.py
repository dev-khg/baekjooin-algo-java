import collections
import heapq
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
products = list(map(int, input().split()))
multi_tap = set()
answer = 0

for i in range(K):
    if products[i] in multi_tap:
        continue
    elif len(multi_tap) < N:
        multi_tap.add(products[i])
        continue

    visited = set()
    count = 0
    for j in range(i, K):
        if products[j] in multi_tap and products[j] not in visited:
            count += 1
            visited.add(products[j])

        if count == N - 1:
            break

    for product in multi_tap:
        if product not in visited:
            multi_tap.remove(product)
            multi_tap.add(products[i])
            answer += 1
            break

print(answer)