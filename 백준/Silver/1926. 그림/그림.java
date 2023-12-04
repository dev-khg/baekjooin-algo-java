
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    total++;
                    count = 0;
                    dfs(board, i, j);

                    max = Math.max(count, max);
                }
            }
        }

        if (total == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(total);
            System.out.println(max);
        }
    }

    private static void dfs(int[][] board, int y, int x) {
        board[y][x] = 0;
        count++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length && board[ny][nx] == 1) {
                dfs(board, ny, nx);
            }
        }
    }
}
