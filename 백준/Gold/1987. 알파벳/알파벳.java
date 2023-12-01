
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(board, 0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(char[][] board, int y, int x, int count) {
        int bitMask = (1 << (board[y][x] - 'A'));
        visited |= bitMask;
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length) {
                int nextBit = (1 << (board[ny][nx] - 'A'));
                if((visited & nextBit) == 0) {
                    visited |= nextBit;
                    dfs(board, ny, nx, count + 1);
                    visited &= ~nextBit;
                }
            }
        }
    }
}