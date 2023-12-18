import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] copy = arr.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for (int i = 0; i < copy.length; i++) {
            if(!map.containsKey(copy[i])) {
                map.put(copy[i], idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }

        System.out.println(sb);
    }
}