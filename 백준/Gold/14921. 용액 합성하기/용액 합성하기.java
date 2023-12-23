import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0, rt = arr.length - 1;

        int answer = Integer.MAX_VALUE;
        int ret = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                ret = sum;
            }

            if (sum >= 0) {
                rt--;
            } else lt++;
        }

        System.out.println(ret);
    }
}