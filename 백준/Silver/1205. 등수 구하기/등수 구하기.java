
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        if(N == P && arr[0] >= score) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > score) {
                rank++;
            } else break;
        }

        System.out.println(rank);
    }
}