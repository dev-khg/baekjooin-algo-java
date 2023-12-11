
import java.io.*;
import java.util.*;

public class Main {
    static int divider = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {

            dp[i][0] = dp[i - 1][1] % divider;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % divider;
            }
            dp[i][9] = dp[i - 1][8] % divider;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum % divider + dp[N][i] % divider;
        }

        System.out.println(sum % divider);
    }
}