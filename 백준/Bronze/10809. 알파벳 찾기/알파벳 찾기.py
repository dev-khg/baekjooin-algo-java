S = input()

total_alpha_count = 26
check = [-1] * total_alpha_count
begin_value = ord('a')

for i in range(len(S)):
    alpha_idx = ord(S[i]) - begin_value
    if check[alpha_idx] == -1:
        check[alpha_idx] = i

for i in range(total_alpha_count):
    print(check[i], end=' ')
