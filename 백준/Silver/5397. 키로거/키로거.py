

T = int(input())


for _ in range(T):
    left = []
    right = []

    for c in input():
        if c == '<':
            if left:
                right.append(left.pop())
        elif c == '>':
            if right:
                left.append(right.pop())
        elif c == '-':
            if left:
                left.pop()
        else:
            left.append(c)

    while left:
        right.append(left.pop())
    right.reverse()
    print(''.join(right))
