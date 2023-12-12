
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] before = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(before, -1);

        int[] dp = new int[N];
        int maxLength = 1;
        int idx = 0;
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    before[i] = j;
                    if (maxLength < dp[i]) {
                        idx = i;
                        maxLength = dp[i];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLength).append("\n");

        dfs(idx, before, arr, sb);

        System.out.println(sb);
    }

    private static void dfs(int idx, int[] before, int[] arr, StringBuilder sb) {
        if (before[idx] == -1) {
            sb.append(arr[idx]).append(" ");
            return;
        }
        dfs(before[idx], before, arr, sb);
        sb.append(arr[idx]).append(" ");
    }
}