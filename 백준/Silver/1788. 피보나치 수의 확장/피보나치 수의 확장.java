
import java.io.*;
import java.util.*;

public class Main {
    static int remainder = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1_000_001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % remainder;
        }

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0 + "\n" + 0);
        } else if (n > 0) {
            System.out.println(1 + "\n" + dp[n]);
        } else {
            if (n % 2 == 0) {
                System.out.println(-1 + "\n" + dp[Math.abs(n)]);
            } else {
                System.out.println(1 + "\n" + dp[Math.abs(n)]);
            }
        }
    }
}