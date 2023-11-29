
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0, rt = N - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if(sum < 0) {
                lt++;
            } else rt--;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}