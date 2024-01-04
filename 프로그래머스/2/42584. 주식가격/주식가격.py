def solution(prices):
    stack = []
    answer = [0] * len(prices)
    for idx in range(len(prices)):
        while stack and prices[stack[-1]] > prices[idx]:
            answer[stack[-1]] = idx - stack[-1]
            stack.pop()
        stack.append(idx)
    
    while stack:
        idx = stack.pop()
        answer[idx] = len(prices) - idx - 1
    
    return answer