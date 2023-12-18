import java.io.*;
import java.util.*;

public class Main {
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        dp = new boolean[N + 1];
        Arrays.fill(dp, true);
        dp[0] = dp[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if(dp[i]) {
                for (int j = i * i; j <= N; j += i) {
                    dp[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if(dp[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}