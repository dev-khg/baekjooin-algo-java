import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            while (!s.isEmpty() && s.peek() > height) {
                s.pop();
                answer += 1;
            }

            if (!s.isEmpty() && s.peek() == height) {
                continue;
            }

            s.add(height);
        }

        while (!s.isEmpty() && s.pop() > 0) {
            answer += 1;
        }

        System.out.println(answer);
    }


}
