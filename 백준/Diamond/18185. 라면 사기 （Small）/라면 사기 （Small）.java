
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 2];
        arr[arr.length - 1] = 0;
        arr[arr.length - 2] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                int two = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                res += two * 5;
                arr[i] -= two;
                arr[i + 1] -= two;

                int three = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                res += 7 * three;
                arr[i] -= three;
                arr[i + 1] -= three;
                arr[i + 2] -= three;
            } else {
                int three = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                res += 7 * three;
                arr[i] -= three;
                arr[i + 1] -= three;
                arr[i + 2] -= three;

                int two = Math.min(arr[i], arr[i + 1]);
                res += 5 * two;
                arr[i] -= two;
                arr[i + 1] -= two;
            }
            res += 3 * arr[i];
        }

        System.out.println(res);
    }
}