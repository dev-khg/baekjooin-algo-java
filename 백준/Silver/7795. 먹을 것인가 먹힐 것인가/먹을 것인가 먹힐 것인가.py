
TC = int(input())

for _ in range(TC):
    N, M = map(int, input().split())
    A = [int(s) for s in input().split()]
    B = [int(s) for s in input().split()]
    A.sort()
    B.sort()
    ptr = 0
    sum = 0

    for a_idx in range(N):
        while True:
            if ptr == M or A[a_idx] <= B[ptr]:
                sum += ptr
                break
            ptr += 1

    print(sum)
