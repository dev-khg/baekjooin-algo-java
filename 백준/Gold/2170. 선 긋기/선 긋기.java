import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        long sum = arr[0][1] - arr[0][0];
        int preY = arr[0][1];
        int preX = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            if (preX <= arr[i][0] && preY >= arr[i][1]) continue;

            if (arr[i][0] <= preY) {
                sum += arr[i][1] - preY;
            } else {
                sum += arr[i][1] - arr[i][0];
            }
            preX = arr[i][0];
            preY = arr[i][1];
        }

        System.out.println(sum);
    }
}