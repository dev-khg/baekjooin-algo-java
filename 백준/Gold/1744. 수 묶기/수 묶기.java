import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int lessThanZeroCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= 0) lessThanZeroCount++;
        }
        int answer = 0;

        Arrays.sort(arr);

        int idx = 0;
        while (idx < lessThanZeroCount) {
            if (idx + 1 < n && arr[idx + 1] <= 0) {
                answer += arr[idx + 1] * arr[idx];
                idx += 2;
            } else {
                answer += arr[idx];
                idx += 1;
            }
        }

        int pIdx = n - 1;
        while (idx <= pIdx) {
            if(pIdx - 1 >= 0 && arr[pIdx - 1] >= 0) {
                answer += Math.max(arr[pIdx] + arr[pIdx - 1],arr[pIdx] * arr[pIdx - 1]);
                pIdx -= 2;
            } else answer += arr[pIdx--];
        }

        System.out.println(answer);
    }

}