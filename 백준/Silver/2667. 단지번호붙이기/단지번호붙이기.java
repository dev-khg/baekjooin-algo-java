
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static int[][] board;
    static int count = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        list.sort(Comparator.comparingInt(a -> a));

        int size = list.size();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        board[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < board.length && nx < board.length && board[ny][nx] == 1) {
                count++;
                dfs(ny, nx);
            }
        }
    }
}
