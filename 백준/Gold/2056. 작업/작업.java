import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        int[] cost = new int[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                graph.get(Integer.parseInt(st.nextToken())).add(i);
                inDegree[i]++;
            }
        }

        System.out.println(solve(graph, inDegree, cost));
    }

    private static int solve(List<List<Integer>> graph, int[] inDegree, int[] cost) {
        int answer = 0;

        int[] result = new int[inDegree.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                result[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();

            for (Integer next : graph.get(current)) {
                result[next] = Math.max(result[next], result[current] + cost[next]);
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }

        return answer;
    }
}