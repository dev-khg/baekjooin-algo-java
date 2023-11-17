import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[100]; 
        Arrays.fill(temp, 0);
        int day = 0;
        
        for(int i=0; i<progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            temp[day]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] != 0) {
                list.add(temp[i]);   
            }            
        }
        
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}