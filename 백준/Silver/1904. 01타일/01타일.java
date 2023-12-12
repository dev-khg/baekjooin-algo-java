
import java.io.*;
import java.util.*;

public class Main {
    static int remainder = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        if (n <= 2) {
            System.out.println(n);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % remainder;
        }

        System.out.println(dp[n]);
    }
}