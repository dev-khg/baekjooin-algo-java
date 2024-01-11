import collections

n, w, L = map(int, input().split())
trucks = [int(s) for s in input().split()]
total_weight = 0
bridge_queue = collections.deque([0] * w)
answer = 0
for truck in trucks:
    if total_weight + truck > L:
        while total_weight + truck > L:
            answer += 1
            total_weight -= bridge_queue.popleft()
            bridge_queue.append(0)
        total_weight += truck
        bridge_queue[w - 1] = truck
    else:
        total_weight -= bridge_queue.popleft()
        total_weight += truck
        bridge_queue.append(truck)
        answer += 1

answer += w
print(answer)