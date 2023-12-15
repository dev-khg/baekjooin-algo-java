import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("-");
        int answer = 0;

        for (int i = 0; i < split.length; i++) {
            int sum = 0;
            String[] spl = split[i].split("\\+");
            for (String s : spl) {
                sum += Integer.parseInt(s);
            }

            if (i == 0) {
                answer -= sum;
            } else
                answer += sum;
        }

        System.out.println(answer * -1);
    }
}