def solution(s):
    strs = s.split()
    nums = [int(str) for str in strs]
    nums.sort()
    answer = str(nums[0]) + ' ' + str(nums[len(nums) - 1])
    return answer