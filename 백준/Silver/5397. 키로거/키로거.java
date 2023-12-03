
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for (char aChar : chars) {
                if (aChar == '<') {
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (aChar == '>') {
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (aChar == '-') {
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(aChar);
                }
            }

            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }

            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}