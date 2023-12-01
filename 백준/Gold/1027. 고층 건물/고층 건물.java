
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        buildings = new int[N];

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, solve(i));
        }

        System.out.println(answer);
    }

    private static int solve(int N) {
        int cnt = 0;
        double beforeSlope = 0;

        for (int i = N - 1; i >= 0; i--) {
            double slope = (double) (buildings[i] - buildings[N]) / (i - N);

            if(i == N - 1 || beforeSlope > slope) {
                cnt++;
                beforeSlope = slope;
            }
        }
        beforeSlope = 1;
        for (int i = N + 1; i < buildings.length; i++) {
            double slope = (double) (buildings[i] - buildings[N]) / (i - N);

            if(i == N + 1 || beforeSlope < slope) {
                cnt++;
                beforeSlope = slope;
            }
        }

        return cnt;
    }
}