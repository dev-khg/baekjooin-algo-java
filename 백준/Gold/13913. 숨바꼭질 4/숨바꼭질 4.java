
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
        int K = Integer.parseInt(st.nextToken());


        int[] cost = new int[100001];
        int[] before = new int[100001];

        cost[N] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            if (poll == K) {
                break;
            }

            int next;

            next = poll - 1;
            if (next >= 0 && cost[next] == 0) {
                before[next] = poll;
                cost[next] = cost[poll] + 1;
                q.offer(next);
            }
            next = poll + 1;
            if (next <= 100000 && cost[next] == 0) {
                before[next] = poll;
                cost[next] = cost[poll] + 1;
                q.offer(next);
            }
            next = poll * 2;
            if (next <= 100000 && cost[next] == 0) {
                before[next] = poll;
                cost[next] = cost[poll] + 1;
                q.offer(next);
            }
        }

        Stack<Integer> stack = new Stack<>();
        int pre = K;
        stack.push(K);
        while (pre != N) {
            int point = before[pre];
            stack.push(point);
            pre = point;
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        sb.append(size - 1).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }
}
