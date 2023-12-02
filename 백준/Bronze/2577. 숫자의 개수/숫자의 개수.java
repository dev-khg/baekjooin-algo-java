
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ret = 1;
        int[] counts = new int[10];

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
            ret *= num;
            
        }

        while (ret > 0) {
            counts[ret % 10]++;
            ret /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(counts[i]);
        }
    }
}