import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 과목의 수
        int M = Integer.parseInt(st.nextToken()); // 선수 조건의 수

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // A -> B
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }

        System.out.println(solve(graph, inDegree));
    }

    private static String solve(List<List<Integer>> graph, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[inDegree.length];

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();

            for (Integer next : graph.get(current)) {
                result[next] = Math.max(result[next], result[current] + 1);
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        return sb.toString();
    }
}