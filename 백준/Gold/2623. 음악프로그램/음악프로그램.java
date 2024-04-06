import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // PD의 수

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int nums = Integer.parseInt(st.nextToken());

            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < nums; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(pre).add(next);
                pre = next;

                inDegree[next]++;
            }
        }

        System.out.println(solve(graph, inDegree));

    }

    private static String solve(List<List<Integer>> graph, int[] inDegree) {
        List<Integer> sequence = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer current = q.poll();
            sequence.add(current);

            for (Integer next : graph.get(current)) {
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(sequence.size() != inDegree.length - 1) {
            sb.append("0");
        } else {
            for (Integer node : sequence) {
                sb.append(node).append("\n");
            }
        }

        return sb.toString();
    }
}