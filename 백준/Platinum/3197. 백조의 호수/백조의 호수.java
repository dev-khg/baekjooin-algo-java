
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Point> waterQ = new LinkedList<>();
        Queue<Point> q = new LinkedList<>();
        Point[] swans = new Point[2];
        char[][] board = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int swanIdx = 0;

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'L') {
                    swans[swanIdx++] = new Point(i, j);
                }
                if (board[i][j] != 'X') {
                    waterQ.offer(new Point(i, j));
                }
            }
        }

        q.offer(swans[0]);
        visited[swans[0].y][swans[0].x] = true;
        boolean meet = false;
        int day = 0;
        while (true) {
            Queue<Point> nextQ = new LinkedList<>();

            while (!q.isEmpty()) {
                Point poll = q.poll();

                if (poll.y == swans[1].y && poll.x == swans[1].x) {
                    meet = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = poll.y + dy[i], nx = poll.x + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (board[ny][nx] == 'X') {
                            nextQ.offer(new Point(ny, nx));
                            continue;
                        }

                        q.offer(new Point(ny, nx));
                    }
                }
            }

            if (meet) break;
            q = nextQ;

            int waterSize = waterQ.size();
            for (int i = 0; i < waterSize; i++) {
                Point poll = waterQ.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j], nx = poll.x + dx[j];

                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && board[ny][nx] == 'X') {
                        board[ny][nx] = '.';
                        waterQ.offer(new Point(ny, nx));
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}