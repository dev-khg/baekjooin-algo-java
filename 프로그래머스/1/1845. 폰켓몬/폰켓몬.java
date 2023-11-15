import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        
        for(int num : nums) {
            sets.add(num);
        }
        
        int len = nums.length / 2;
        
        return len <= sets.size() ? len : sets.size();
    }
}