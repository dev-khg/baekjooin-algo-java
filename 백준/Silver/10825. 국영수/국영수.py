
N = int(input())

score = []

for _ in range(N):
    name, kor, eng, math = input().split()
    score.append([name, int(kor), int(eng), int(math)])

for people in sorted(score, key=lambda x:(-x[1], x[2], -x[3], x[0])):
    print(people[0])