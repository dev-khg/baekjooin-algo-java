
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        if(A > B) {
            long tmp = A;
            A = B;
            B = tmp;
        } else if(A == B) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((B - A - 1) + "\n");

        for (long i = A + 1; i < B; i++) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}