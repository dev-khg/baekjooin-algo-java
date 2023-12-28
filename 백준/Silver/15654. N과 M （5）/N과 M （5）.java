import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int S;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, new int[S]);

        System.out.println(sb);
    }

    private static void dfs(int L, int[] temp) {
        if (temp.length == L) {
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[L] = nums[i];
                dfs(L + 1, temp);
                visited[i] = false;
            }
        }
    }
}