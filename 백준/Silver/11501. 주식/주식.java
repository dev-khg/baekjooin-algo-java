
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long max = arr[arr.length - 1];
            long answer = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                if(arr[i] <= max) {
                    answer += (max - arr[i]);
                } else {
                    max = arr[i];
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}