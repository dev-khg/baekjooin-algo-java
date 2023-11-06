import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    Integer poll = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(poll);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}