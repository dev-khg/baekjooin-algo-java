import collections

cog_wheels = []
cog_wheels.append([])
left = -1
right = 1
cog_top_idx = 0
cog_left_idx = 6
cog_right_idx = 2

for _ in range(4):
    cog_wheels.append(collections.deque(input()))

K = int(input())


def rotate_queue(q: collections.deque,direction: int) -> None:
    q.rotate(direction)


def spread(current_idx: int, progress_direction: int, rotate_direction: int) -> None:
    global cog_wheels
    if current_idx <= 0 or current_idx >= 5:
        return


    if progress_direction == right:
        if cog_wheels[current_idx][cog_left_idx] != cog_wheels[current_idx - 1][cog_right_idx]:
            spread(current_idx + progress_direction, progress_direction, -rotate_direction)
            rotate_queue(cog_wheels[current_idx], rotate_direction)
    else:
        if cog_wheels[current_idx][cog_right_idx] != cog_wheels[current_idx + 1][cog_left_idx]:
            spread(current_idx + progress_direction, progress_direction, -rotate_direction)
            rotate_queue(cog_wheels[current_idx], rotate_direction)



for i in range(K):
    no, direction = map(int, input().split())
    spread(no - 1, left, -direction)
    spread(no + 1, right, -direction)
    rotate_queue(cog_wheels[no], direction)


answer = 0

for i in range(1, 5):
    answer |= (int(cog_wheels[i][0]) << (i - 1))

print(answer)