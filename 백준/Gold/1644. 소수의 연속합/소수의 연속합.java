import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime[];
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        isPrime = new boolean[N + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) for (int j = i * i; j <= N; j += i) isPrime[j] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!isPrime[i]) nums.add(i);
        }

        int lt = 0, sum = 0, count = 0;
        int size = nums.size();

        for (int rt = 0; rt < size; rt++) {
            sum += nums.get(rt);

            if (sum == N) {
                count++;
            }
            while (sum >= N) {
                sum -= nums.get(lt++);
                if(sum == N) count++;
            }
        }

        System.out.println(count);
    }
}