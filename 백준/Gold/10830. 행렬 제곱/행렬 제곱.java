import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken()) % 1000;
            }
        }

        long[][] result = solve(matrix, B);

        for (long[] longs : result) {
            for (long aLong : longs) {
                System.out.print(aLong + " ");
            }
            System.out.println();
        }
    }

    static long[][] solve(long[][] matrix, long B) {
        if(B == 1L) {
            return matrix;
        }

        long[][] solve = solve(matrix, B / 2);

        solve = multiply(solve, solve);

        if(B % 2 == 1) {
            solve = multiply(solve, matrix);
        }
        return solve;
    }

    static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        int N = matrix1.length;
        long[][] ret = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    ret[i][j] += matrix1[i][k] * matrix2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }

        return ret;
    }
}