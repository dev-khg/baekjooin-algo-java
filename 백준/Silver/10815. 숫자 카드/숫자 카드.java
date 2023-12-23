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
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (isExists(arr, Integer.parseInt(st.nextToken()))) {
                sb.append("1");
            } else sb.append("0");

            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static boolean isExists(int[] arr, int target) {
        int lt = 0, rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                rt = mid - 1;
            } else lt = mid + 1;

        }
        return false;
    }
}