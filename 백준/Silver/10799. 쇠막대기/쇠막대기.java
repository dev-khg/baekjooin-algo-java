
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push('(');
            else { // )
                if (chars[i - 1] == '(') {
                    stack.pop();
                    answer += stack.size();
                } else if (chars[i - 1] == ')') {
                    stack.pop();
                    answer += 1;
                } else {
                    stack.pop();
                }
            }
        }

        System.out.println(answer);
    }
}