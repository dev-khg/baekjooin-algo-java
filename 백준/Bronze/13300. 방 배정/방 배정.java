
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] students = new int[7][2];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            students[grade][gender]++;
        }

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (students[i][j] != 0) {
                    count += (students[i][j] + (K - 1)) / K;
                }
            }
        }

        System.out.println(count);
    }
}