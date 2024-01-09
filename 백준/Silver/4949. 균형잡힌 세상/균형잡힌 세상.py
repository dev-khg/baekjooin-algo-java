import heapq

answer = []
bracket_open_set = {
    '(', '['
}
bracket_close_set = {
    ']', ')'
}
bracket_dict = {
    ')': '(',
    ']': '['
}

while True:
    s = input()

    if s == '.':
        break

    stack = []
    is_valid = True

    for c in s:
        if c in bracket_open_set:
            stack.append(c)
        elif c in bracket_close_set:
            if not stack:
                is_valid = False
                break
            if bracket_dict[c] != stack[-1]:
                is_valid = False
                break
            stack.pop()

    if not is_valid or stack:
        answer.append("no")
    else:
        answer.append("yes")


print('\n'.join(answer))