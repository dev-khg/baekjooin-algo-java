import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static String[] targetWord;
    static char[][] board;
    static int N;
    static int M;
    static int K;
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int maxLength;
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][];
        targetWord = new String[K];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < K; i++) {
            targetWord[i] = br.readLine();
            maxLength = Math.max(maxLength, targetWord[i].length());
            memo.put(targetWord[i], 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(0, i, j, "");
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String key : targetWord) {
            sb.append(memo.get(key)).append("\n");
        }

        System.out.println(sb);
    }

    private static void find(int L, int y, int x, String temp) {
        temp += board[y][x];

        if (memo.containsKey(temp)) {
            memo.put(temp, memo.get(temp) + 1);
        }

        if (L + 1 >= maxLength) {
            return;
        }

        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i], nx = x + dx[i];

            if (ny >= N) {
                ny = 0;
            } else if (ny < 0) {
                ny = N - 1;
            }

            if (nx >= M) {
                nx = 0;
            } else if (nx < 0) {
                nx = M - 1;
            }

            find(L + 1, ny, nx, temp);
        }
    }


}