
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] days = new long[N + 1];
        long[] profits = new long[N + 1];
        long[] dp = new long[N + 1];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            days[i] = Long.parseLong(st.nextToken());
            profits[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (days[i] + i <= N) {
                dp[(int) (days[i] + i)] = Math.max(dp[i] + profits[i], dp[(int) (days[i] + i)]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
