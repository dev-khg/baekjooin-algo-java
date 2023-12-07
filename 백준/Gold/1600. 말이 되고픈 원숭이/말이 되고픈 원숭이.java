
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // y x
    static int[][] moves = {
            {1, 0},
            {-1, 0},
            {0, -1},
            {0, 1},
    };
    static int[][] jumps = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] board = new int[H][W][K + 1];
        boolean[][][] visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0});

        int answer = -1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int count = poll[2];
            int cost = poll[3];
            if (visited[y][x][count]) continue;
            visited[y][x][count] = true;

            if (y == H - 1 && x == W - 1) {
                answer = cost;
                break;
            }

            if (count < K) {
                for (int[] jump : jumps) {
                    int ny = y + jump[0], nx = x + jump[1];
                    if (ny >= 0 && nx >= 0 && ny < H && nx < W && !visited[ny][nx][count + 1] && board[ny][nx][0] == 0) {
                        q.offer(new int[]{ny, nx, count + 1, cost + 1});
                    }
                }
            }

            for (int[] move : moves) {
                int ny = y + move[0], nx = x + move[1];
                if (ny >= 0 && nx >= 0 && ny < H && nx < W && !visited[ny][nx][count] && board[ny][nx][0] == 0) {
                    q.offer(new int[]{ny, nx, count, cost + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
