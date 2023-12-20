
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lt = 0, rt = 0;

        while (lt <= rt && rt < N) {
            int diff = arr[rt] - arr[lt];

            if(diff >= M) {
                lt++;
                answer = Math.min(diff, answer);
            } else rt++;
        }

        System.out.println(answer);
    }
}