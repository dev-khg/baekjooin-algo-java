import collections

N = int(input())
counter = collections.Counter([int(s) for s in input().split()])
M = int(input())
targets = [int(s) for s in input().split()]

for target in targets:
    if counter[target] > 0:
        print(1)
    else:
        print(0)