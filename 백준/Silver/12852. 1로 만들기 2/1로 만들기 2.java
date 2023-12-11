
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] back = new int[N + 1];

        back[1] = -1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            back[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                back[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                back[i] = i / 3;
            }
        }

        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();

        int num = N;
        while (back[num] != -1) {
            sb.append(num).append(" ");
            num = back[num];
        }
        sb.append("1");

        System.out.println(sb);
    }
}
