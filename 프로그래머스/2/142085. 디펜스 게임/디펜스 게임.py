from heapq import heappop, heappush

def solution(n, k, enemy):
    answer, totalEnemy = 0, 0
    max_heap = []
    
    for e in enemy:
        heappush(max_heap, -e)
        totalEnemy += e
        if totalEnemy > n:
            if k == 0:
                break
            totalEnemy += heappop(max_heap)
            k -= 1
        answer += 1    
    
    
    return answer