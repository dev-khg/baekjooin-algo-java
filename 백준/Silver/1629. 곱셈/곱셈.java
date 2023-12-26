import java.io.*;
import java.util.*;

public class Main {
    static long remainder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        remainder = Long.parseLong(st.nextToken());

        long answer = pow(A, B);

        System.out.println(answer);
    }

    private static long pow(long a, long b) {
        if (b == 1) return a % remainder;

        long temp = pow(a, b / 2);

        if(b % 2 == 1) {
            return (temp * temp % remainder) * a % remainder;
        }

        return temp * temp % remainder;
    }
}