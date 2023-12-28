import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, -1, new int[6]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int L, int pre, int[] temp) {
        if(L == 6) {
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pre + 1; i < nums.length; i++) {
            temp[L] = nums[i];
            dfs(L + 1, i, temp);
        }
    }
}