
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> stack = new Stack<>();

        int[] answer = new int[N + 1];
        int[] count = new int[N + 1];
        Arrays.fill(answer, -100000);

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                stack.pop();
            }

            int size = stack.size();
            if(size > 0) {
                count[i] += size;
                answer[i] = stack.peek()[0];
            }
            stack.push(new int[]{i, arr[i]});
        }

        stack = new Stack<>();

        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                stack.pop();
            }

            int size = stack.size();

            if (size > 0) {
                count[i] += size;
                if (stack.peek()[0] - i < i - answer[i]) {
                    answer[i] = stack.peek()[0];
                }
            }
            stack.push(new int[]{i, arr[i]});
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if(count[i] != 0) {
                sb.append(count[i]).append(" ").append(answer[i]);
            } else sb.append(0);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
