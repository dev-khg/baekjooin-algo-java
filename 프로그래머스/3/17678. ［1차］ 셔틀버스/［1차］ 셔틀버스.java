import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pQ = new PriorityQueue<Integer>();
        
        for (String time : timetable) {
            pQ.add(timetableToInt(time));
        }
        
        int start = 6 * 90;
        int last = 0;
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            total = 0;
            while(!pQ.isEmpty()) {
                int currentTime = pQ.peek();
                if(currentTime <= start && total < m) {
                    pQ.poll();
                    total++;
                } else break;
                
                last = currentTime - 1;
            }
            start += t;
        }
        
        if (total < m) last = start - t;
        
        return intToTimetable(last);
    }
    
    public int timetableToInt(String time) {
        String[] split = time.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }
    
    public String intToTimetable(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}