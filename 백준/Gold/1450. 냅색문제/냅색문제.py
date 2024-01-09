

N, C = map(int, input().split())
sumA = []
sumB = []

nums = [int(s) for s in input().split()]
A_W = nums[:N // 2]
B_W = nums[N // 2:]


def dfs(warr, sum_arr, l, w):
    if l >= len(warr):
        sum_arr.append(w)
        return
    dfs(warr, sum_arr, l + 1, w)
    dfs(warr, sum_arr, l + 1, w + warr[l])


def binary_search(arr, target):
    lt, rt = 0, len(arr)
    while lt < rt:
        mid = (lt + rt) // 2
        if arr[mid] <= target:
            lt = mid + 1
        else:
            rt = mid
    return rt

dfs(A_W, sumA, 0, 0)
dfs(B_W, sumB, 0, 0)
sumB.sort()
answer = 0



for i in sumA:
    if C - i < 0:
        continue
    answer += binary_search(sumB, C - i)

print(answer)


