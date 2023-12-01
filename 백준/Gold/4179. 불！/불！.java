
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] fireVisited;
    static boolean[][] jihoonVisited;
    static char[][] board;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        fireVisited = new boolean[R][C];
        jihoonVisited = new boolean[R][C];

        Queue<Point> jQ = new LinkedList<>();
        Queue<Point> fQ = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = chars[j];
                if (board[i][j] == 'J') {
                    jQ.offer(new Point(i, j));
                    jihoonVisited[i][j] = true;
                } else if (board[i][j] == 'F') {
                    fQ.offer(new Point(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }

        int time = 0;
        while (!jQ.isEmpty()) {
            int jSize = jQ.size();
            int fSize = fQ.size();

            for (int i = 0; i < fSize; i++) {
                Point poll = fQ.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j], nx = poll.x + dx[j];
                    if (isIn(ny, nx) && board[ny][nx] != '#' && !fireVisited[ny][nx]) {
                        fireVisited[ny][nx] = true;
                        board[ny][nx] = 'F';
                        fQ.offer(new Point(ny, nx));
                    }
                }
            }

            for (int i = 0; i < jSize; i++) {
                Point poll = jQ.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j], nx = poll.x + dx[j];
                    if (!isIn(ny, nx)) {
                        System.out.println(time + 1);
                        return;
                    }

                    if (board[ny][nx] == '.' && !jihoonVisited[ny][nx]) {
                        jihoonVisited[ny][nx] = true;
                        jQ.offer(new Point(ny, nx));
                    }
                }
            }
            time++;
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean isIn(int y, int x) {
        return 0 <= x && x < C && 0 <= y && y < R;
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