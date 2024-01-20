import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = getNextLong(st);
            long d = getNextLong(st);
            long x = getNextLong(st);

            long lt = 1;
            long rt = 1000000;
            long floor = 0;
            long floorLeft = 0;
            while (lt <= rt) {
                long mid = (lt + rt) / 2;

                var temp = 1 + a * (mid - 1) + d * (mid - 1) * (mid - 2) / 2;

                if (temp <= x) {
                    floor = mid;
                    floorLeft = temp;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            sb.append(floor).append(" ").append(x - floorLeft + 1).append("\n");
        }
        
        System.out.println(sb);
    }

    private static int getNextLong(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}