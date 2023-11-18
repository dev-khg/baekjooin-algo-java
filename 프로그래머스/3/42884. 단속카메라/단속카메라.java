import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        int com = Integer.MIN_VALUE;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        for(int[] route : routes) {
            if(com < route[0]) {
                com = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}