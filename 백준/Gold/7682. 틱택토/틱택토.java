
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = null;

        while (!(input = br.readLine()).equals("end")) {
            int ptr = 0;
            char[][] board = new char[3][3];
            int xCount = 0;
            int oCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(ptr++);
                    if (board[i][j] == 'X') xCount++;
                    else if (board[i][j] == 'O') oCount++;
                }
            }

            if (oCount > xCount) {
                sb.append("invalid\n");
            } else if (oCount + xCount == 9 && xCount == 5) {
                boolean x = isBingo('X', board);
                boolean o = isBingo('O', board);
                if (x && o) sb.append("invalid\n");
                else if (o) sb.append("invalid\n");
                else sb.append("valid\n");
            } else {
                boolean x = isBingo('X', board);
                boolean o = isBingo('O', board);
                if (x && o) sb.append("invalid\n");
                else if (x && xCount == oCount + 1) sb.append("valid\n");
                else if (o && xCount == oCount) sb.append("valid\n");
                else sb.append("invalid\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isBingo(char c, char[][] board) {
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == c) count++;
                else break;
            }
            if (count == 3) return true;
        }

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == c) count++;
                else break;
            }
            if (count == 3) return true;
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == c) return true;
        if (board[0][2] == board[1][1] && board[2][0] == board[1][1] && board[0][2] == c) return true;

        return false;
    }
}