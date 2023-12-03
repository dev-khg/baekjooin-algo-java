
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;
        boolean flag = true;
        while (N-- > 0 && flag) {
            int num = Integer.parseInt(br.readLine());

            if (num > start) {
                for (int i = start + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                start = num;
            } else if (stack.peek() != num) {
                flag = false;
                break;
            }

            stack.pop();
            sb.append("-\n");
        }

        if (flag) {
            System.out.println(sb);
        }  else {
            System.out.println("NO");
        }
    }
}