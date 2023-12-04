
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pQ.offer(new Edge(1, 0));
        int sum = 0;

        while (!pQ.isEmpty()) {
            Edge poll = pQ.poll();
            if (visited[poll.v]) continue;
            visited[poll.v] = true;
            sum += poll.cost;

            for (Edge edge : graph.get(poll.v)) {
                if (!visited[edge.v]) {
                    pQ.offer(new Edge(edge.v, edge.cost));
                }
            }
        }

        System.out.println(sum);
    }

    static class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}