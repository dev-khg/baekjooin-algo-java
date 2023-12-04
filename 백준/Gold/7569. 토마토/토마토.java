
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // y x z
    static int[][] point = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, 1},
            {0, 0, -1},
    };
    static int[][][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        board = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    board[z][y][x] = Integer.parseInt(st.nextToken());
                    if (board[z][y][x] == 1) {
                        q.offer(new int[]{z, y, x});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int[] ints : point) {
                int nz = poll[0] + ints[0];
                int ny = poll[1] + ints[1];
                int nx = poll[2] + ints[2];

                if (ny >= 0 && nx >= 0 && nz >= 0 && ny < N && nx < M && nz < H && board[nz][ny][nx] == 0) {
                    board[nz][ny][nx] = board[poll[0]][poll[1]][poll[2]] + 1;
                    q.offer(new int[]{nz, ny, nx});
                }
            }
        }

        int i = checkDone(board);
        if (i == -1)
            System.out.println(-1);
        else
            System.out.println(i - 1);
    }

    static int checkDone(int[][][] board) {
        int count = 0;
        for (int i = 0; i < board[0][0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {
                    if (board[j][k][i] == 0) return -1;
                    count = Math.max(count, board[j][k][i]);
                }
            }
        }
        return count;
    }
}
