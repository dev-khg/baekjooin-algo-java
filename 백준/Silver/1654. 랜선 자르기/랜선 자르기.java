import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long answer = 0;
        long lt = 1, rt = arr[arr.length - 1];

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += calculate(arr[i], mid);
            }

            if(count >= K) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(answer);
    }

    private static long calculate(long len, long mid) {
        return len / mid;
    }
}