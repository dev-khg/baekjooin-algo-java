
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedList<int[]> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!q.isEmpty() && q.getLast()[1] > num) {
                q.removeLast();
            }

            q.offer(new int[]{i, num});
            while (q.peek()[0] < i - L + 1) {
                q.poll();
            }
            sb.append(q.peek()[1]).append(" ");
        }

        System.out.println(sb);
    }
}