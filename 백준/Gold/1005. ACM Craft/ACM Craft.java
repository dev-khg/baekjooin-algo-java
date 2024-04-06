import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙 개수

            int[] buildingTime = new int[N + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                buildingTime[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] inDegree = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                // X -> Y
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                inDegree[Y]++;
                graph.get(X).add(Y);
            }

            int W = Integer.parseInt(br.readLine()); // 건설 목표 건물 번호

            int[] result = solve(graph, buildingTime, inDegree);

            sb.append(result[W])
                    .append("\n");
        }

        System.out.println(sb);
    }

    private static int[] solve(List<List<Integer>> graph, int[] buildingTime, int[] inDegree) {
        int[] result = new int[buildingTime.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < buildingTime.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = buildingTime[i];
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();

            for (Integer next : graph.get(current)) {
                result[next] = Math.max(result[next], result[current] + buildingTime[next]);
                inDegree[next] -= 1;

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return result;
    }
}