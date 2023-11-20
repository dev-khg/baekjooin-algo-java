class Solution {
    public String solution(String number, int k) {
        int answerLength = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0;  i < answerLength; i++) {
            char max = '0';
            for(int j = start; j <= i + k; j++) {                
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}