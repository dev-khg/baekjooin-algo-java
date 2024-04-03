import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] moves = {
            {-1, 0, 0},
            {1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, 1},
            {0, 0, -1},
    };

    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] board = new int[N][M][H];

        Queue<int[]> tomatoQ = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[j][k][i] = Integer.parseInt(st.nextToken());

                    if (board[j][k][i] == 1) {
                        tomatoQ.offer(new int[]{j, k, i}); // y, x, z
                    }
                }
            }
        }

        int answer = 0;

        while (!tomatoQ.isEmpty()) {
            int size = tomatoQ.size();
            answer++;

            for (int i = 0; i < size; i++) {
                int[] poll = tomatoQ.poll();

                for (int[] move : moves) {
                    int ny = poll[0] + move[0], nx = poll[1] + move[1], nz = poll[2] + move[2];

                    if (isInRange(ny, nx, nz) && board[ny][nx][nz] == 0) {
                        board[ny][nx][nz] = 1;
                        tomatoQ.offer(new int[]{ny, nx, nz});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer - 1);
    }

    static boolean isInRange(int y, int x, int z) {
        return y >= 0 && x >= 0 && z >= 0 && y < N && x < M && z < H;
    }
}