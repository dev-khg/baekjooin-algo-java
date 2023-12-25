import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long[] answer = new long[3];
        long pre = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int lt = i + 1, rt = N - 1;

            while (lt < rt) {
                long sum = arr[lt] + arr[rt] + arr[i];

                if (pre > Math.abs(sum)) {
                    pre = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[lt];
                    answer[2] = arr[rt];
                }

                if (sum > 0) {
                    rt--;
                } else lt++;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}