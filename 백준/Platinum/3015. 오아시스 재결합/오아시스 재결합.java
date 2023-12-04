
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            Pair pair = new Pair(Integer.parseInt(br.readLine()), 1);

            while (!stack.isEmpty() && stack.peek().height <= pair.height) {
                Pair pop = stack.pop();
                cnt += pop.cnt;
                if(pop.height == pair.height) {
                    pair.cnt += pop.cnt;
                }
            }

            if(!stack.isEmpty()) cnt++;

            stack.push(pair);
        }

        System.out.println(cnt);
    }

    static class Pair {
        int height;
        int cnt;

        public Pair(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}