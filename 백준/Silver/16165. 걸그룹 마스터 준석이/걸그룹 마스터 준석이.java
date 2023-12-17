import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Map<String, Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            HashMap<String, Integer> value = new HashMap<>();
            int count = Integer.parseInt(br.readLine());

            for (int j = 0; j < count; j++) {
                value.put(br.readLine(), 1);
            }
            map.put(group, value);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 1) {
                for (String s : map.keySet()) {
                    if (map.get(s).containsKey(name)) {
                        sb.append(s).append("\n");
                        break;
                    }
                }
            } else {
                ArrayList<String> strings = new ArrayList<>(map.get(name).keySet());
                strings.sort(String::compareTo);

                for (String string : strings) {
                    sb.append(string).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}