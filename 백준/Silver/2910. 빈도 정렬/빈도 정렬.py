import collections

N, M = map(int, input().split())

values = [int(s) for s in input().split()]
counter = collections.Counter(values)

counter = sorted(counter.items(), key=lambda x: (-x[1]))

for element in counter:
    num, count = element
    for _ in range(count):
        print(num, end=' ')
