import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        Queue<int[]> tomatoQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    tomatoQ.offer(new int[]{i, j});
                }
            }
        }

        while (!tomatoQ.isEmpty()) {
            int[] poll = tomatoQ.poll();
            for (int j = 0; j < 4; j++) {
                int ny = poll[0] + dy[j], nx = poll[1] + dx[j];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && board[ny][nx] == 0) {
                    board[ny][nx] = board[poll[0]][poll[1]] + 1;
                    tomatoQ.offer(new int[]{ny, nx});
                }
            }
        }

        int days = checkDone(board);
        if (days == -1)
            System.out.println(-1);
        else
            System.out.println(days - 1);
    }

    static int checkDone(int[][] board) {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) return -1;
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }
}