import math
import sys

n = int(input())

is_prime = [True] * (n + 1)
primes = []
is_prime[0] = is_prime[1] = False
for i in range(2, int(math.sqrt(n)) + 1):
    if is_prime:
        for j in range(2 * i, n + 1, i):
            is_prime[j] = False

for i in range(len(is_prime)):
    if is_prime[i]:
        primes.append(i)

lt, rt = 0, 0
answer = 0
sum = 0
for rt in range(len(primes)):
    sum += primes[rt]
    if sum == n:
        answer += 1
    while sum >= n:
        sum -= primes[lt]
        lt += 1
        if sum == n:
            answer += 1

print(answer)
