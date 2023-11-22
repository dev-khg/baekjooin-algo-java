
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        int offCount = 0;
        int onCount = 0;
        for (char aChar : chars) {
            if (aChar == '0') {
                offCount++;
            } else onCount++;
        }

        onCount /= 2;
        offCount /= 2;

        for (int i = 0; i < chars.length && onCount > 0; i++) {
            if (chars[i] == '1') {
                onCount--;
                chars[i] = '.';
            }
        }

        for (int i = chars.length - 1; i >= 0 && offCount > 0; i--) {
            if (chars[i] == '0') {
                offCount--;
                chars[i] = '.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != '.')
                sb.append(aChar);
        }

        System.out.println(sb);
    }
}