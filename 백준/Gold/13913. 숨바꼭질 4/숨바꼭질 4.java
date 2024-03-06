
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] before = new int[100001];
        int[] cost = new int[100001];

        cost[N] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            Integer current = q.poll();

            if(current == K) {
                break;
            }

            int next = current + 1;
            if (next >= 0 && next <= 10_0000 && cost[next] == 0) {
                q.add(next);
                cost[next] = cost[current] + 1;
                before[next] = current;
            }

            next = current - 1;
            if (next >= 0 && next <= 10_0000 && cost[next] == 0) {
                q.add(next);
                cost[next] = cost[current] + 1;
                before[next] = current;
            }

            next = current * 2;
            if (next >= 0 && next <= 10_0000 && cost[next] == 0) {
                q.add(next);
                cost[next] = cost[current] + 1;
                before[next] = current;
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