import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N + 1] = L;

        Arrays.sort(arr);
        int lt = 1, rt = L - 1;

        while (lt <= rt) {
            int distance = (lt + rt) / 2;
            int count = 0;

            for (int i = 1; i < arr.length; i++) {
                count += (arr[i] - arr[i - 1] - 1) / distance;
            }

            if (count > M) {
                lt = distance + 1;
            } else rt = distance - 1;
        }

        System.out.println(lt);
    }
}