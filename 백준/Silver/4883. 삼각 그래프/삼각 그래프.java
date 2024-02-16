import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;

        int tc = 0;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] dp = new int[N][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = dp[0][1];
            dp[0][2] = dp[0][1] + dp[0][2];

            for (int i = 1; i < N; i++) {
                dp[i][0] += getMin(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += getMin(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i][0]);
                dp[i][2] += getMin(dp[i - 1][1], dp[i - 1][2], dp[i][1]);
            }


            System.out.println(++tc + ". " + dp[N - 1][1]);
        }
    }

    static int getMin(int... args) {
        int min = Integer.MAX_VALUE;

        for (int arg : args) {
            if (min > arg) {
                min = arg;
            }
        }
        return min;
    }
}