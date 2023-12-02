
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int years = Integer.parseInt(br.readLine());

        if(years % 400 == 0 || (years % 4 == 0 && years % 100 != 0)) {
            System.out.println(1);
        } else System.out.println(0);
    }
}