import collections
import heapq
import itertools


class Egg:
    def __init__(self, durability: int, weight: int):
        self.durability = durability
        self.weight = weight

    def crash_egg(self, other) -> None:
        self.durability, other.durability = (
            self.durability - other.weight, other.durability - self.weight
        )

    def crash_rollback(self, other) -> None:
        self.durability, other.durability = (
            self.durability + other.weight, other.durability + self.weight
        )

    def is_broken(self) -> bool:
        return self.durability <= 0


answer = 0


def dfs(left: int, broken_count: int):
    global eggs, answer, N
    if left == N:
        answer = max(answer, broken_count)
        return

    if eggs[left].is_broken() or broken_count == N - 1:
        dfs(left + 1, broken_count)
        return

    left_hand = eggs[left]
    for right in range(len(eggs)):
        if left == right:
            continue
        right_hand = eggs[right]
        if not right_hand.is_broken():
            left_hand.crash_egg(right_hand)
            broken = 0
            if left_hand.is_broken():
                broken += 1
            if right_hand.is_broken():
                broken += 1
            dfs(left + 1, broken_count + broken)
            left_hand.crash_rollback(eggs[right])


N = int(input())
eggs: list[Egg] = []

for _ in range(N):
    S, W = map(int, input().split())
    eggs.append(Egg(S, W))

dfs(0, 0)

print(answer)


