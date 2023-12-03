
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            int len = input.length();
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                } else {
                  stack.push('(');
                }
            }

            if (stack.isEmpty() && flag) {
                sb.append("YES");
            } else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }

}