
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int ANSWER = Integer.MAX_VALUE;
    static int[] dy = {1, 1, 1};
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, board[0][i], 3, board);
        }

        System.out.println(ANSWER);
    }

    private static void dfs(int y, int x, int sum, int pre, int[][] board) {
        if (y == board.length - 1) {
            ANSWER = Math.min(ANSWER, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (pre != i && nx >= 0 && nx < board[0].length) {
                dfs(ny, nx, sum + board[ny][nx], i, board);
            }
        }
    }
}