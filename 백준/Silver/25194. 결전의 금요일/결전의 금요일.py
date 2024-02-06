import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int,input().split()))
dp = [0]*7 # 나머지를 담을 dp
dp[0] = 1 # 나머지 0

for a in A: # A의 요소 하나씩 꺼냄
    temp = [0]*7
    for j in range(7): 
        if dp[j]:               # 만약 나머지 j가 이미 있다면
            temp[(a+j) % 7] = 1 # 거기에 a를 더하고 나머지 연산을 한다.
            temp[j] = 1        
    dp = temp # 이전에 계산된 내용들과 지금 숫자와 계산해서 새롭게 생긴 나머지가 섞이지 않기 위해 분리
if dp[4]:
    print("YES")
else: 
    print("NO")

