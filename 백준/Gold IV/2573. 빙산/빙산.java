
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int areaCount;
        while ((areaCount = getAreaCount()) < 2 && areaCount != 0) {
            days++;
            melt();
        }

        if (areaCount == 0) {
            System.out.println(areaCount);
        } else
            System.out.println(days);
    }

    private static void melt() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
                if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length && !visited[ny][nx] && board[ny][nx] <= 0) {
                    count++;
                }
            }

            board[poll[0]][poll[1]] -= count;
        }
    }

    static int getAreaCount() {
        int count = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    count++;
                    dfs(i, j, visited);
                }
            }
        }

        return count;
    }

    private static void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length && !visited[ny][nx] && board[ny][nx] > 0) {
                dfs(ny, nx, visited);
            }
        }
    }
}
