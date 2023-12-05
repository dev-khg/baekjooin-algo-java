
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] moves = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
    };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Point current = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Point destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            Queue<Point> q = new LinkedList<>();
            q.offer(current);

            visited = new boolean[n][n];

            while (!q.isEmpty()) {
                Point poll = q.poll();
                if (visited[poll.y][poll.x]) continue;
                visited[poll.y][poll.x] = true;
                if (poll.y == destination.y && poll.x == destination.x) {
                    sb.append(poll.cost).append("\n");
                    break;
                }

                for (int[] move : moves) {
                    int ny = poll.y + move[0], nx = poll.x + move[1];
                    if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) {
                        q.offer(new Point(ny, nx, poll.cost + 1));
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

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.cost = count;
        }
    }
}
