import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int size;
    public static int[][] chess;

    public static int[] dy = {-1, -1, 1, 1}; // 좌상, 우상, 좌하, 우하
    public static int[] dx = {-1, 1, -1, 1}; // 좌상, 우상, 좌하, 우하

    public static int b_cnt = 0;
    public static int w_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        size = Integer.parseInt(br.readLine());

        chess = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= size; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] black_visited = new boolean[size + 1][size + 1];
        black_search(black_visited, 1, 1, 0);

        boolean[][] white_visited = new boolean[size + 1][size + 1];
        white_search(white_visited, 1, 2, 0);

        System.out.println(b_cnt + w_cnt);
    }

    public static void black_search(boolean[][] visited, int y, int x, int cnt) {
        b_cnt = Math.max(cnt, b_cnt);

        if (x > size) {
            y += 1;
            x = (y % 2 == 0) ? 2 : 1;
        }

        if (y > size) return;

        if (isAble(visited, y, x)) {
            visited[y][x] = true;
            black_search(visited, y, x + 2, cnt + 1);
            visited[y][x] = false;
        }

        black_search(visited, y, x + 2, cnt);
    }

    public static void white_search(boolean[][] visited, int y, int x, int cnt) {
        w_cnt = Math.max(cnt, w_cnt);

        if (x > size) {
            y += 1;
            x = (y % 2 == 0) ? 1 : 2;
        }

        if (y > size) return;

        if (isAble(visited, y, x)) {
            visited[y][x] = true;
            white_search(visited, y, x + 2, cnt + 1);
            visited[y][x] = false;
        }

        white_search(visited, y, x + 2, cnt);
    }


    public static boolean isAble(boolean[][] visited, int y, int x) {
        if (chess[y][x] == 0) return false; // 0이면 놓을 수 없다.

        for (int i = 0; i < 4; i++) {
            int yy = dy[i] + y;
            int xx = dx[i] + x;

            for (int j = 1; j <= size; j++) {
                if (yy > 0 && xx > 0 && yy <= size && xx <= size) {
                    if (visited[yy][xx]) return false;

                    yy += dy[i];
                    xx += dx[i];
                }
            }
        }
        return true;
    }
}
