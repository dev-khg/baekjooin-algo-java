import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        int answer = -1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int cost = poll[2];
            int dist = poll[3];

            if (y == N - 1 && x == M - 1) {
                answer = dist + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
                    if (board[ny][nx] == 0 && !visited[ny][nx][cost]) {
                        visited[ny][nx][cost] = true;
                        q.add(new int[]{ny, nx, cost, dist + 1});
                    } else if (board[ny][nx] == 1 && cost < K && !visited[ny][nx][cost + 1]) {
                        visited[ny][nx][cost + 1] = true;
                        q.add(new int[]{ny, nx, cost + 1, dist + 1});
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
