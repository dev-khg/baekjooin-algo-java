
domain_password_dict = dict()

N, M = map(int, input().split())

for _ in range(N):
    domain, password = input().split()
    domain_password_dict[domain] = password

for _ in range(M):
    print(domain_password_dict[input()])