import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
         int[] answer = new int[2];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);

            if (command.equals("I")) {
                maxHeap.offer(value);
                minHeap.offer(value);
            } else if (command.equals("D")) {
                if (!maxHeap.isEmpty()) {
                    if (value == 1) {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    } else if (value == -1) {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}