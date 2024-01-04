
def rotation(arr: list[list[int]]) -> list[list[int]]:
    n = len(arr)
    m = len(arr[0])
    temp = [[0 for _ in range(n)] for _ in range(m)]

    for i in range(n):
        for j in range(m):
            temp[j][n - i - 1] = arr[i][j]
    return temp


def is_promise(y: int, x: int, sticker: list[list[int]], graph: list[list[int]]) -> bool:
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if graph[y + i][x + j] + sticker[i][j] > 1:
                return False
    return True


def attach(y: int, x: int, sticker: list[list[int]], graph: list[list[int]]):
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            graph[y + i][x + j] += sticker[i][j]


# N : 세로, M : 가로, K : 스티커 개수
N, M, K = map(int, input().split())
laptop = [[0 for _ in range(M)] for _ in range(N)]

for _ in range(K):
    R, C = map(int, input().split())
    current_sticker = [[int(s) for s in input().split()] for _ in range(R)]
    rotate_count = 0
    attached = False

    while rotate_count < 4 and not attached:
        for y in range(N - len(current_sticker) + 1):
            for x in range(M - len(current_sticker[0]) + 1):
                if is_promise(y, x, current_sticker, laptop):
                    attach(y, x, current_sticker, laptop)
                    attached = True
                    break
            if attached:
                break
        if attached:
            break
        rotate_count += 1
        current_sticker = rotation(current_sticker)

answer = 0
for i in range(N):
    for j in range(M):
        answer += laptop[i][j]


print(answer)

