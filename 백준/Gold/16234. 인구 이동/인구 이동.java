
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static boolean move;
    static int days;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited;

        while (true) {
            visited = new boolean[N][N];
            move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j, visited);
                    }
                }
            }

            if (move) {
                days++;
            } else break;

        }

        System.out.println(days);
    }

    private static void bfs(int y, int x, boolean[][] visited) {
        Point point = new Point(y, x);
        List<Point> points = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        visited[y][x] = true;
        points.add(point);
        q.offer(point);

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i], nx = poll.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < visited.length && nx < visited[0].length && !visited[ny][nx]) {
                    int abs = Math.abs(board[ny][nx] - board[poll.y][poll.x]);
                    if (abs >= L && abs <= R) {
                        Point next = new Point(ny, nx);
                        points.add(next);
                        q.offer(next);
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        if (points.size() > 1) {
            int sum = 0;
            for (Point point1 : points) {
                sum += board[point1.y][point1.x];
            }

            int avg = sum / points.size();

            for (Point point1 : points) {
                board[point1.y][point1.x] = avg;
            }
            move = true;
        }
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