def solution(people, limit):
    answer = 0
    
    people.sort()
    
    lt, rt = 0, len(people) - 1
    
    while lt <= rt:
        if people[lt] + people[rt] <= limit:            
            lt += 1
        rt -= 1
        answer += 1
    
    return answer