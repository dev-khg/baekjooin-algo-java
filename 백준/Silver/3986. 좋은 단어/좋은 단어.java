
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            int len = input.length();
            if((len & 0x01) > 0) continue;

            for (int i = 0; i < len; i++) {
                char item = input.charAt(i);

                if (!stack.isEmpty() && stack.peek() == item) {
                    stack.pop();
                } else stack.push(item);
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}