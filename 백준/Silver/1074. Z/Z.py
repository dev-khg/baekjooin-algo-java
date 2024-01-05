

N, r, c = map(int, input().split())


def dfs(row: int, col: int, n: int, value: int):
    n = n // 2
    if row < n and col < n:
        if n == 1:
            print(value)
            exit(0)
        dfs(row, col, n, value)
    elif row < n and col >= n:
        if n == 1:
            print(value + 1)
            exit(0)
        dfs(row, col - n, n, value + (n ** 2))
    elif row >= n and col < n:
        if n == 1:
            print(value + 2)
            exit(0)
        dfs(row - n, col,n,  value + (n ** 2) * 2)
    else:
        if n == 1:
            print(value + 3)
            exit(0)
        dfs(row - n, col - n, n, value + (n ** 2) * 3)

dfs(r, c, 2 ** N, 0)

