import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            inDegree[B] += 1;
        }

        int[] result = solve(N, inDegree, graph);

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] solve(int n, int[] inDegree, List<List<Integer>> graph) {
        int[] result = new int[n];
        int resultPtr = 0;

        Queue<Integer> q = new PriorityQueue<>();
 // 4 -> 2 / 3 -> 1
        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();
            result[resultPtr++] = current;

            for (Integer next : graph.get(current)) {
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return result;
    }
}