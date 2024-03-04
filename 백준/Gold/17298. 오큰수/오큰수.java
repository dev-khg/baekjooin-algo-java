import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        int[] nums = new int[N];
        Arrays.fill(answer, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                answer[i] = s.peek();
            }
            s.push(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}