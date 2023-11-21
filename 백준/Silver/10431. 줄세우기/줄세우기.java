
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static String sang = "SK";
    private static String chang = "CY";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            sb.append(N);
            Arrays.fill(arr, 0);
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (k = j - 1; k >= 0; k--) {
                    if (num < arr[k]) {
                        count++;
                        arr[k + 1] = arr[k];
                    } else {
                        break;
                    }
                }
                arr[k + 1] = num;
            }
            sb.append(" " + count + "\n");
        }

        System.out.println(sb);
    }
}