
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] chars = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'P') {
                if (findLeft(i, chars, K) != NOT_FOUND) {
                    count++;
                } else if (findRight(i, chars, K) != NOT_FOUND) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static int findLeft(int i, char[] chars, int k) {
        int maxLeft = Math.max(i - k, 0);

        for (int j = maxLeft; j < i; j++) {
            if (chars[j] == 'H') {
                chars[j] = '.';
                return j;
            }
        }
        return NOT_FOUND;
    }

    private static int findRight(int i, char[] chars, int k) {
        int maxRight = Math.min(i + k, chars.length - 1);
        for (int j = i; j <= maxRight; j++) {
            if (chars[j] == 'H') {
                chars[j] = '.';
                return j;
            }
        }
        return NOT_FOUND;
    }
}