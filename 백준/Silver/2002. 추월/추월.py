import collections

N = int(input())

tunnel_in = collections.deque()
tunnel_out = collections.deque()
tunnel_set = set()


for _ in range(N):
    car = input()
    tunnel_in.append(car)
    tunnel_set.add(car)

for _ in range(N):
    tunnel_out.append(input())

answer = 0
while tunnel_out:
    if tunnel_in[0] == tunnel_out[0]:
        tunnel_in.popleft()
        tunnel_out.popleft()
    else:
        answer += 1
        tunnel_in.remove(tunnel_out.popleft())

print(answer)