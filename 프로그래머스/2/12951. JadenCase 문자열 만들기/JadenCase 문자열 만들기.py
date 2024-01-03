def solution(s):
    strs = s.lower().split(' ')
    answer = []
    
    for str in strs:
        if str == "":
            answer.append(str)
            continue
        answer.append(str[0].upper() + str[1:])

    return ' '.join(answer)
