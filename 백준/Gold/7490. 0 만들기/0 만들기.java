
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            N = Integer.parseInt(br.readLine());

            dfs(1, 1, 0, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int L, int num, int sum, int op, String str) {
        if (L == N) {
            if (sum + (op * num) == 0) {
                sb.append(str + "\n");
            }
            return;
        }
        int curr = L + 1;

        dfs(L + 1, num * 10 + curr, sum, op, str + " " + curr);
        dfs(L + 1, curr, sum + (num * op), 1, str + "+" + (curr));
        dfs(L + 1, curr, sum + (num * op), -1, str + "-" + (curr));
    }
}