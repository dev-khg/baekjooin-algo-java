
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char doo = 'A';
    static char gae = 'B';
    static char girl = 'C';
    static char yoot = 'D';
    static char moo = 'E';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 3;
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[4];
            int oneCount = 0;
            int zeroCount = 0;
            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            if (zeroCount == 4) System.out.println(yoot);
            else if (oneCount == 4) System.out.println(moo);
            else if (zeroCount == 3) System.out.println(girl);
            else if (zeroCount == 2) System.out.println(gae);
            else System.out.println(doo);
        }
    }
}