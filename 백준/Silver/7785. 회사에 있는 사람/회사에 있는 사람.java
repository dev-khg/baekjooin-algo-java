import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String type = st.nextToken();

            if(type.equals("enter")) {
                map.put(name, 1);
            } else {
                map.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }

    }
}