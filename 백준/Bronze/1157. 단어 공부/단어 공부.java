
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int[] arr = new int[30];

        s = s.toUpperCase();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'A'] += 1;
        }

        int max = 0;
        char now = '?';
        for (int i = 'A'; i <= 'Z'; i++) {
            if (max < arr[i - 'A']) {
                now = (char) i;
                max = arr[i - 'A'];
            } else if (max == arr[i - 'A']) {
                now = '?';
            }
        }

        System.out.println(now);
    }
}