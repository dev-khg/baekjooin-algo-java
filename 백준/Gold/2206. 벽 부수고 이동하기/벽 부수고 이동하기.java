
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static int M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        int[][][] check = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        check[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[1] == N - 1 && poll[2] == M - 1) {
                System.out.println(check[poll[0]][N - 1][M - 1]);
                return;
            }

            int broken = poll[0];
            for (int i = 0; i < 4; i++) {
                int ny = poll[1] + dy[i];
                int nx = poll[2] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                if (board[ny][nx] == 0) {
                    if (check[broken][ny][nx] == 0) {
                        check[broken][ny][nx] = check[broken][poll[1]][poll[2]] + 1;
                        q.offer(new int[]{broken, ny, nx});
                    }
                } else {
                    if (check[1][ny][nx] == 0 && broken == 0) {
                        check[1][ny][nx] = check[0][poll[1]][poll[2]] + 1;
                        q.offer(new int[]{1, ny, nx});
                    }
                }
            }
        }

        System.out.println(-1);
    }
}