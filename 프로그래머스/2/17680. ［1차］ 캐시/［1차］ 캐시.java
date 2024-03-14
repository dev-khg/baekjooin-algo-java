import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> q = new LinkedList<>();
        
        for(int i = 0; i <cacheSize; i++) {
            q.offer("");
        }
        
        boolean flag;
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            flag = false;
            for(int j = 0; j < cacheSize; j++) {
                if(q.get(j).equals(cities[i])) {                    
                    flag = true;
                    q.remove(cities[i]);
                    q.offer(cities[i]);
                    answer += 1;
                    break;
                }
            }
            if(!flag) {
                q.poll();
                q.offer(cities[i]);
                answer += 5;
            }
        }
        
        return answer;
    }
}