class Solution {
    static int answer = 51;
    public int solution(String begin, String target, String[] words) {
        
        boolean[] used = new boolean[words.length];
        dfs(begin, target, 0, words, used);
        
        return answer == 51 ? 0 : answer;
    }
    
    static void dfs(String now, String target, int L, String[] words, boolean[] used) {
        if(now.equals(target)) {
            answer = Math.min(answer, L);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!used[i] && check(now, words[i])) {
                used[i] = true;
                dfs(words[i], target, L + 1, words, used);
                used[i] = false;
            }
        }
    }
    
    static boolean check(String now, String word) {
        int count = 0;
        for(int i = 0; i < now.length(); i++) {
            if(now.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
}