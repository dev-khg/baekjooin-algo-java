

N = int(input())

rows = []
answer = 0


def is_promissing(row: int, col: int) -> bool:
    global rows

    for r, c in enumerate(rows):
        if r == row or c == col:
            return False
        elif abs(r - row) == abs(c - col):
            return False

    return True


def dfs(L: int):
    global rows, N, answer

    if L == N:
        answer += 1
        return

    for i in range(N):
        if is_promissing(L, i):
            rows.append(i)
            dfs(L + 1)
            rows.pop()

dfs(0)
print(answer)