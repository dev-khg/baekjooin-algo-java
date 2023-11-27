
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Edge>> graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        solve();

        System.out.print(distance[N]);

    }

    static void solve() {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        distance[1] = 0;
        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {
            Edge current = pQ.poll();

            if (current.cost > distance[current.vertex]) continue;

            for (Edge edge : graph.get(current.vertex)) {
                if (distance[edge.vertex] > distance[current.vertex] + edge.cost) {
                    distance[edge.vertex] = distance[current.vertex] + edge.cost;
                    pQ.offer(new Edge(edge.vertex, distance[edge.vertex]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}