
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] roads = new int[N - 1];
        int[] stations = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stations[i] = Integer.parseInt(st.nextToken());
        }

        int min = stations[0];
        int costTotal = stations[0] * roads[0];

        for(int i = 1; i < roads.length; i++) {
            min = Math.min(min, stations[i]);
            costTotal += min * roads[i];
        }

        System.out.println(costTotal);
    }
}