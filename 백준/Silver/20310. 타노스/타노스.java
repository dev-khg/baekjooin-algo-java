
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int inputLength = input.length();
        input = input.replaceAll("0", "");
        int onCount = input.length();
        int offCount = inputLength - onCount;
        offCount /= 2;
        onCount /= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < offCount; i++) {
            sb.append(0);
        }
        for (int i = 0; i < onCount; i++) {
            sb.append(1);
        }

        System.out.println(sb);
    }
}