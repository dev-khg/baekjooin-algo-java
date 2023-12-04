
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        visited[0][0] = true;
        distance[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    distance[ny][nx] = distance[poll[0]][poll[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        System.out.println(distance[n - 1][m - 1]);

    }

}
