
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a = (1 << 0);
    static int b = (1 << 1);
    static int c = (1 << 2);
    static int d = (1 << 3);
    static int e = (1 << 4);
    static int f = (1 << 5);
    static int g = (1 << 6);
    static int[] num = {
            a | b | c | e | f | g,      // 0
            c | f,                      // 1
            a | c | d | e | g,          // 2
            a | c | d | f | g,          // 3
            b | c | d | f,              // 4
            a | b | d | f | g,          // 5
            a | b | d | e | f | g,      // 6
            a | c | f,                  // 7
            a | b | c | d | e | f | g,  // 8
            a | b | c | d | f | g,      // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 1~N 층
        int K = Integer.parseInt(st.nextToken()); // K 자리
        int P = Integer.parseInt(st.nextToken()); // 반전 가능 개수
        int X = Integer.parseInt(st.nextToken()); // 현재 층
        int[] digits = numToDigit(X, K);
        int solve = solve(digits, X, P, N);
        System.out.println(solve - 1);
    }

    static int count = 0;

    private static int solve(int[] digits, int x, int p, int n) {
        for (int i = 1; i <= n; i++) {
            if (diffCount(i, digits) <= p) {
                count++;
            }
        }
        return count;
    }

    private static int diffCount(int target, int[] digits) {
        int diffCount = 0;
        int[] arr = numToDigit(target, digits.length);
        for (int i = 0; i < digits.length; i++) {
            diffCount += Integer.bitCount(num[arr[i]] ^ num[digits[i]]);
        }
        return diffCount;
    }

    public static int[] numToDigit(int x, int k) {
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
}