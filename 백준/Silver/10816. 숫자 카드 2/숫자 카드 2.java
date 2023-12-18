import java.io.*;
import java.util.*;

public class Main {
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(highBound(arr, target) - lowerBound(arr, target)).append(' ');
        }

        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (target <= arr[mid]) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }

    static int highBound(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if(target < arr[mid]) {
                rt = mid;
            } else lt = mid + 1;
        }

        return lt;
    }
}