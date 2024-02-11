
N = int(input())

rows = [0] * N
answer = 0

def is_promissing(row: int, col: int) -> bool:
    global rows

    for r in range(row):
        if r == row or rows[r] == col:
            return False
        elif abs(r - row) == abs(rows[r] - col):
            return False

    return True


def dfs(L: int):
    global rows, N, answer

    if L == N:
        answer += 1
        return

    for i in range(N):
        rows[L] = i
        if is_promissing(L, i):
            dfs(L + 1)

dfs(0)
print(answer)