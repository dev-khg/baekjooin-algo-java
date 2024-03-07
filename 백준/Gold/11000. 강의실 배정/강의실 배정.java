import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i] = new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(schedules, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        int time = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int startTime = schedules[i].start;
            int endTime = schedules[i].end;

            if (!pQ.isEmpty() && pQ.peek() <= startTime) {
                pQ.poll();
            }
            pQ.offer(endTime);
        }

        System.out.println(pQ.size());
    }

    static class Schedule {
        private int start;
        private int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}