
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            board[vertex1][vertex2] = 1;
            board[vertex2][vertex1] = 1;
        }

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        dfs(V, visited);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V, visited);

        System.out.println(sb);
    }

    private static void dfs(int v, boolean[] visited) {
        visited[v] = true;
        sb.append(v + " ");
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && board[v][i] == 1) {
                dfs(i, visited);
            }
        }
    }

    private static void bfs(int v, boolean[] visited) {
        visited[v] = true;
        sb.append(v + " ");
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 1; i < visited.length; i++) {
                if(!visited[i] && board[poll][i] == 1) {
                    visited[i] = true;
                    sb.append(i + " ");
                    q.offer(i);
                }
            }
        }
    }
}