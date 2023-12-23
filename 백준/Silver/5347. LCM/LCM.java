import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long l = A * B / gcd(A, B);
            sb.append(l).append("\n");
        }

        System.out.println(sb);
    }

    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}