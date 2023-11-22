
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int inputLength = input.length();
            if (inputLength < M) continue;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            if (map.get(a).intValue() == map.get(b).intValue()) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return b.length() - a.length();
            }
            return map.get(b).intValue() - map.get(a).intValue();
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}