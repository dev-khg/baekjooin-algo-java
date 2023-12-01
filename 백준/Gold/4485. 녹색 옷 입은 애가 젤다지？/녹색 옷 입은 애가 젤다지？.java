
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 1;
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] board = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            Queue<Point> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            pQ.offer(new Point(0, 0, board[0][0]));
            visited[0][0] = true;
            while (!pQ.isEmpty()) {
                Point poll = pQ.poll();

                if(poll.y == N - 1 && poll.x == N - 1) {
                    sb.append("Problem " + idx++ + ": " + poll.cost + "\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = poll.y + dy[i], nx = poll.x + dx[i];
                    if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        pQ.offer(new Point(ny, nx, poll.cost + board[ny][nx]));
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Point {
        int y;
        int x;
        int cost;

        public Point(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}