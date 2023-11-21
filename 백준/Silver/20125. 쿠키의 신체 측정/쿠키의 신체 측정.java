
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Point heart = null;
        Point hurry = null;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (heart == null && isHeart(board, i, j)) {
                    heart = new Point(i, j);
                }
                if (hurry == null && isHurry(board, i, j)) {
                    hurry = new Point(i, j);
                }
                if (hurry != null && heart != null) break;
            }
        }

        int leftHand = 0;
        int rightHand = 0;
        int leftFoot = 0;
        int rightFoot = 0;
        for (int i = 0; i < N; i++) {
            if (board[heart.y][i] == '*') {
                leftHand = i;
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (board[heart.y][i] == '*') {
                rightHand = i;
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if(board[i][hurry.x - 1] == '*') {
                leftFoot = i;
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if(board[i][hurry.x + 1] == '*') {
                rightFoot = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((heart.y + 1) + " " + (heart.x + 1) + "\n");
        sb.append((heart.x - leftHand) + " ").append((rightHand - heart.x) + " ");
        sb.append((hurry.y - heart.y) + " ").append((leftFoot - hurry.y) + " ").append((rightFoot - hurry.y));

        System.out.println(sb);
    }

    static boolean isHeart(char[][] board, int y, int x) {
        return (board[y - 1][x] == '*') && (board[y + 1][x] == '*')
                && (board[y][x + 1] == '*') && (board[y][x - 1] == '*') && (board[y][x] == '*');
    }

    static boolean isHurry(char[][] board, int y, int x) {
        return (board[y + 1][x + 1] == '*') && (board[y + 1][x - 1] == '*')
                && (board[y + 1][x] != '*');
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