import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(String op : operations) {
            String[] split = op.split(" ");
            int num = Integer.parseInt(split[1]);
            if(split[0].equals("I")) {
                maxHeap.offer(num);
                minHeap.offer(num);                    
            }  else {
                if(maxHeap.isEmpty()) continue;
                else if ( num > 0 ) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if(minHeap.isEmpty()) return new int[] {0, 0};
        
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}