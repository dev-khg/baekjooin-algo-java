class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] nums = { 4, 1, 2};
        
        while(n > 0) {
            sb.append(nums[n % 3]);
            n = (n - 1) / 3;
        }        
        
        return sb.reverse().toString();
    }
}