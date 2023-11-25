
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) start = new Point(i, j);
            }
        }

        int[][] count = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        visited[start.y][start.x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start.y, start.x});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];

                if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length && !visited[ny][nx] && board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    count[ny][nx] = count[poll[0]][poll[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 1) count[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(count[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}