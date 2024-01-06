import heapq
import sys

input = sys.stdin.readline

n = int(input())
minheap = []
maxheap = []
vis = {}
for i in range(n):
    p,l = map(int,input().split())
    heapq.heappush(minheap,(l,p))
    heapq.heappush(maxheap,(-l,-p))
    vis[p] = True

m = int(input())
for i in range(m):
    s = list(input().split())
    if s[0]=='add':
        while not vis[minheap[0][1]]:
            heapq.heappop(minheap)
        while not vis[-maxheap[0][1]]:
            heapq.heappop(maxheap)
        vis[int(s[1])] = True
        heapq.heappush(minheap,(int(s[2]),int(s[1])))
        heapq.heappush(maxheap,(-int(s[2]),-int(s[1])))

    elif s[0]=='solved':
        vis[int(s[1])] = False

    else:
        if s[1]=='-1':
            while not vis[minheap[0][1]]:
                heapq.heappop(minheap)
            print(minheap[0][1])
        else:
            while not vis[-maxheap[0][1]]:
                heapq.heappop(maxheap)
            print(-maxheap[0][1])