
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(N, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            if(visited[poll.x]) continue;
            visited[poll.x] = true;
            if(poll.x == K) {
                System.out.println(poll.cost);
                return;
            }

            int nx = 0;
            nx = poll.x + 1;
            if(nx >= 0 && nx <= 100000 && !visited[nx]) {
                q.offer(new Point(nx, poll.cost + 1));
            }
            nx = poll.x - 1;
            if(nx >= 0 && nx <= 100000 && !visited[nx]) {
                q.offer(new Point(nx, poll.cost + 1));
            }
            nx = poll.x * 2;
            if(nx >= 0 && nx <= 100000 && !visited[nx]) {
                q.offer(new Point(nx, poll.cost + 1));
            }
        }

    }

    static class Point {
        int x;
        int cost;

        public Point(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

}
