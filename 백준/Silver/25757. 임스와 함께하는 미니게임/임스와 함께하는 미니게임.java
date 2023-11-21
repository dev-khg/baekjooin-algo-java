
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    private static int getCount(String game) {
        int num = 0;
        switch (game) {
            case "Y":
                num = 1;
                break;
            case "F":
                num = 2;
                break;
            case "O":
                num = 3;
                break;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = getCount(st.nextToken());

        Set<String> strings = new HashSet<>();

        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }

        System.out.println(strings.size() / num);
    }
}