import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[250000];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int input;
        StringBuilder sb = new StringBuilder();

        while ((input = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for (int i = input + 1; i <= 2 * input; i++) {
                if (isPrime[i]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}