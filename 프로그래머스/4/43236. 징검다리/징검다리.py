def solution(distance, rocks, n):
    rocks.sort()
    left, right = 1, distance
    rocks.append(distance)
    
    while left <= right:
        mid = (left + right) // 2
        deleted = 0        
        prev_rock = 0
        
        for rock in rocks:
            dist = rock - prev_rock
            if dist < mid:
                deleted += 1
                if deleted > n:
                    break
            else:
                prev_rock = rock
            
        if deleted > n:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1
    
    return answer
