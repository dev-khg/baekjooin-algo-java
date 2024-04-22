class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[2][sequence.length];
        dp[0][0] = sequence[0];
        dp[1][0] = -sequence[0];
        
        answer = Math.max(dp[0][0], dp[1][0]);
        
        for(int i = 1; i < sequence.length; i++) {
            if((i & 0x01) == 0x01) {
                dp[0][i] = Math.max(dp[0][i - 1] - sequence[i], -sequence[i]);
                dp[1][i] = Math.max(dp[1][i - 1] + sequence[i], sequence[i]);
            } else {
                dp[0][i] = Math.max(dp[0][i - 1] + sequence[i], sequence[i]);
                dp[1][i] = Math.max(dp[1][i - 1] - sequence[i], -sequence[i]);
            }
            
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }
        
        return answer;
    }
}