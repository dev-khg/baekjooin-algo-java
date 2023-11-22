
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int N = 0;
        int strIndex = 0;
        int length = s.length();
        while (true) {
            N++;
            String num = String.valueOf(N);
            for (int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == s.charAt(strIndex)) {
                    strIndex++;
                }
                if(strIndex == length) {
                    System.out.println(N);
                    return;
                }
            }
        }
    }
}