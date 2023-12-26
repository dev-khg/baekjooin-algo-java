import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][K + 1];

        System.out.println(dfs(N, K));
    }

    static long dfs(int N, int K) {
        if(N == K || K == 0) return 1;

        if(dp[N][K] == 0) dp[N][K] = dfs(N - 1, K - 1) + dfs(N - 1, K);
        return dp[N][K];
    }

}