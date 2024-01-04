import collections;
import heapq;

class Node:
    def __init__(self, idx: int, value: int):
        self.idx, self.value = idx, value

def solution(priorities, location):
    max_heap = []
    q = collections.deque()
    
    for idx, value in enumerate(priorities):
        q.append(Node(idx, value))
        heapq.heappush(max_heap, -value)
    
    rank = 1
    
    while q:
        node = q.popleft()
        
        if -max_heap[0] > node.value:
            q.append(node)
            continue
        heapq.heappop(max_heap)
        if node.idx == location:
            break
        rank += 1
    
    return rank