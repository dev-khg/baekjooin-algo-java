
N = int(input())

people_info_list = []

for _ in range(N):
    age, name = input().split()
    people_info_list.append([int(age), name])

people_info_list.sort(key=lambda x:(x[0]))

for person in people_info_list:
    print(person[0], person[1])