
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean[][] sVisited;
    static char[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer = 0;
    static Queue<int[]> fireQ;
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            visited = new boolean[h][w];
            sVisited = new boolean[h][w];
            board = new char[h][w];
            fireQ = new LinkedList<>();

            int[] start = new int[]{0, 0};

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                int len = s.length();
                for (int j = 0; j < len; j++) {
                    board[i][j] = s.charAt(j);

                    if (board[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        visited[i][j] = true;
                    } else if (board[i][j] == '@') {
                        sVisited[i][j] = true;
                        start = new int[]{i, j};
                    }
                }
            }
            int bfs = bfs(start);

            sb.append(bfs == 0 ? "IMPOSSIBLE" : bfs).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int count = 0;

        boolean[][] sVisited = new boolean[h][w];
        while (!q.isEmpty()) {
            count++;
            int fSize = fireQ.size();
            for (int i = 0; i < fSize; i++) {
                int[] poll = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = poll[0] + dy[j], nx = poll[1] + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length && board[ny][nx] != '#' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        board[ny][nx] = '*';
                        fireQ.offer(new int[]{ny, nx});
                    }
                }
            }

            int sSize = q.size();
            for (int i = 0; i < sSize; i++) {
                int[] poll = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = poll[0] + dy[j], nx = poll[1] + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length) {
                        if (!sVisited[ny][nx] && board[ny][nx] == '.') {
                            sVisited[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    } else {
                        return count;
                    }
                }
            }
        }

        return 0;
    }
}
