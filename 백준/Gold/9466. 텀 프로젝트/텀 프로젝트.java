
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            sb.append(N - count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int v) {
        if(visited[v]) return;
        visited[v] = true;
        int next = arr[v];

        if(!visited[next]) {
            dfs(next);
        } else if(!finished[next]) {
            count++;
            while (next != v) {
                next = arr[next];
                count++;
            }
        }

        finished[v] = true;
    }
}