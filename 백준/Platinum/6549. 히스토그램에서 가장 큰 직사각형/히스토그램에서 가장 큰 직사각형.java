
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] histogram;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }
            histogram = new int[N];
            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(N)).append('\n');
            histogram = null;

        }
        System.out.println(sb);
    }

    public static long getArea(int len) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                int h = histogram[stack.pop()];
                int w = 0;

                w = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, (long) h * w);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int h = histogram[stack.pop()];

            int w = stack.isEmpty() ? len : len - 1 - stack.peek();
            maxArea = Math.max(maxArea, (long) h * w);
        }

        return maxArea;
    }
}
