
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[N];
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        int idx = 0;
        while (!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.offer(q.poll());
            }
            nums[idx++] = q.poll();
        }
        sb.append("<").append(nums[0]);
        for (int i = 1; i < N; i++) {
            sb.append(", " + nums[i]);
        }
        sb.append(">");

        System.out.println(sb);
    }
}