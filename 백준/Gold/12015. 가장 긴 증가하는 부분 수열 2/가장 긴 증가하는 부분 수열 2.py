def find_idx(arr, num) -> int:
    lt, rt = 0, len(arr)
    
    while lt <= rt:
        mid = (lt + rt) // 2
        
        if arr[mid] >= num:
            rt = mid - 1
        else:
            lt = mid + 1
    return lt
    
    
N = int(input())
nums = [int(s) for s in input().split()]

stack = []
stack.append(nums[0])

for i in range(N):
    if not stack or stack[-1] < nums[i]:
        stack.append(nums[i])
    else:
        idx = find_idx(stack, nums[i])
        stack[idx] = nums[i]
        
print(len(stack))