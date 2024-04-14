import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] counts = new int[100001];
        long answer = 0;
        int lt = 0, rt = 0;
        while (lt < N) {
            while (rt < N && counts[arr[rt]] == 0) {
                counts[arr[rt]]++;
                rt++;
            }

            answer += rt - lt;
            counts[arr[lt++]]--;
        }

        System.out.println(answer);
    }
}