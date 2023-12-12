import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = getMax(dp[0][i - 1], dp[1][i - 1] + arr[0][i]);
                dp[1][i] = getMax(dp[1][i - 1], dp[0][i - 1] + arr[1][i]);
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }

    static int getMax(int... num) {
        int max = Integer.MIN_VALUE;
        for (int i : num) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}