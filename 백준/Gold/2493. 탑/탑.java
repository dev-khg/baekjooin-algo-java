
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i > 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer pop = stack.pop();
                answer[pop] = i;
            }
            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}