import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        System.out.println(solve(chars));
    }

    private static int solve(char[] chars) {
        if(chars[0] == '0') return 0;

        int[] dp = new int[chars.length + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= chars.length; i++) {
            if(chars[i - 1] == '0') {
                if(chars[i - 2] == '2' || chars[i - 2] == '1') {
                    dp[i] = dp[i - 2] % mod;
                }
                else break;
            } else {
                int total = chars[i - 1] - '0' + ((chars[i - 2] - '0') * 10);

                if(total >= 10 && total <= 26) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                } else {
                    dp[i] = dp[i - 1] % mod;
                }
            }
        }

        return dp[dp.length - 1] % mod;
    }
}