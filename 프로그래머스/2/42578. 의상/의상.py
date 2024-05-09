import collections;

def solution(clothes):
    dict = collections.defaultdict(int)
    answer = 1
    for cloth in clothes:
        dict[cloth[1]] += 1
    
    if len(dict) == 1:
        answer = dict[clothes[0][1]]
    else:        
        for key in dict:
            answer *= (dict[key] + 1)
        answer -= 1
        
    return answer
