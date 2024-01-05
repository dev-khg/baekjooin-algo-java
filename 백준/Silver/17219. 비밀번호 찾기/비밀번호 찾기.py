import sys

input = sys.stdin.readline

N, M = map(int, input().split())
domain_password_dict = dict()

for _ in range(N):
    domain, password = input().split()
    domain_password_dict[domain] = password

for _ in range(M):
    domain = input().rstrip()
    if domain in domain_password_dict:
        print(domain_password_dict[domain])


