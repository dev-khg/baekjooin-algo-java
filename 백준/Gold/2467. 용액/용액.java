
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int answer = Integer.MAX_VALUE;

        int lt = 0, rt = arr.length - 1;
        int A = 0, B = 0;
        while (lt < rt) {
            int abs = Math.abs(arr[lt] + arr[rt]);
            int sum = arr[lt] + arr[rt];

            if(abs < answer) {
                answer = abs;
                A = arr[lt];
                B = arr[rt];
            }

            if(sum < 0) lt++;
            else rt--;
        }

        System.out.println(A + " " + B);
    }
}