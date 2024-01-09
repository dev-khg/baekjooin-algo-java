import heapq

n, m = map(int, input().split())
nums = [int(s) for s in input().split()]

heapq.heapify(nums)

for _ in range(m):
    A, B = heapq.heappop(nums), heapq.heappop(nums)
    heapq.heappush(nums, A + B)
    heapq.heappush(nums, A + B)
    
print(sum(nums))