import java.util.*;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        
        int[] nums = new int[split.length];
        
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        
        Arrays.sort(nums);
        
        return nums[0] + " " + nums[nums.length - 1];
    }
}