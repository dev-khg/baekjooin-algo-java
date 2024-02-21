
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // z y x
    static int[][] points = {
            {-1, 0, 0},
            {1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, 1},
            {0, 0, -1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 & R == 0 && C == 0) break;

            char[][][] board = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            int[] start = new int[]{0, 0, 0};
            int[] end = new int[]{0, 0, 0};

            for (int z = 0; z < L; z++) {
                for (int y = 0; y < R; y++) {
                    String input = br.readLine();
                    int len = input.length();
                    for (int x = 0; x < C; x++) {
                        board[z][y][x] = input.charAt(x);
                        if (board[z][y][x] == 'S') {
                            start = new int[]{z, y, x};
                            visited[z][y][x] = true;
                        } else if (board[z][y][x] == 'E') {
                            end = new int[]{z, y, x};
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs(start, end, board, visited);

            if (answer == -1) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in ").append(answer - 1).append(" minute(s).");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int[] start, int[] end, char[][][] board, boolean[][][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int min = 0;
        while (!q.isEmpty()) {
            min++;
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int[] poll = q.poll();
                if (poll[0] == end[0] && poll[1] == end[1] && poll[2] == end[2]) {
                    return min;
                }
                for (int[] point : points) {
                    int nz = poll[0] + point[0], ny = poll[1] + point[1], nx = poll[2] + point[2];

                    if (nx >= 0 && ny >= 0 && nz >= 0 && nz < visited.length && ny < visited[0].length && nx < visited[0][0].length && !visited[nz][ny][nx]
                            && board[nz][ny][nx] != '#') {
                        q.offer(new int[]{nz, ny, nx});
                        visited[nz][ny][nx] = true;
                    }
                }
            }
        }

         return -1;
    }

}
