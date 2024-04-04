import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int P, Q;
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        System.out.println(dfs(N));
    }

    static long dfs(long num) {
        if (num == 0) return 1;
        if (memo.containsKey(num)) return memo.get(num);

        long A1 = (long) Math.floor(num / P);
        long A2 = (long) Math.floor(num / Q);

        memo.put(num, dfs(A1) + dfs(A2));

        return memo.get(num);
    }
}