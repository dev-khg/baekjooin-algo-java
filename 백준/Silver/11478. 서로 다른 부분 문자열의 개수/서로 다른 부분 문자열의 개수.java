import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> set = new HashSet<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(input.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}