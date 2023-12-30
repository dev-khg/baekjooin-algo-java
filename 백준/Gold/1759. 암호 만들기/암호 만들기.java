import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        chars = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        dfs(0, -1, new char[L]);

        System.out.println(sb);
    }

    private static void dfs(int L, int pre, char[] temp) {
        if (temp.length == L) {
            if(!isValid(temp)) return;
            sb.append(temp).append("\n");
            return;
        }

        for (int i = pre + 1; i < chars.length; i++) {
            temp[L] = chars[i];
            dfs(L + 1, i, temp);
        }
    }

    static boolean isMoem(char c) {
        return c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e';
    }

    static boolean isValid(char[] temp) {
        int mCount = 0;
        int jCount = 0;

        for (char i : temp) {
            if(isMoem(i)) {
                mCount++;
            } else jCount++;
        }

        return mCount > 0 && jCount > 1;
    }
}