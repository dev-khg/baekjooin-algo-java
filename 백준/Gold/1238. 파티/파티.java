
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        int[] distance = new int[N + 1];
        int[] reverseDistance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(reverseDistance, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            reverseGraph.get(to).add(new Node(from, cost));
        }

        solve(graph, distance, X);
        solve(reverseGraph, reverseDistance, X);

        int answer = 0;
        for (int i = 1; i < distance.length; i++) {
            answer = Math.max(answer, distance[i] + reverseDistance[i]);
        }
        System.out.println(answer);
    }

    private static void solve(List<List<Node>> graph, int[] distance, int x) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(x, 0));
        distance[x] = 0;

        while (!pQ.isEmpty()) {
            Node poll = pQ.poll();
            int now = poll.v;
            int cost = poll.cost;

            if(cost > distance[now]) continue;

            for (Node node : graph.get(now)) {
                if(distance[node.v] > node.cost + poll.cost) {
                    distance[node.v] = node.cost + poll.cost;
                    pQ.offer(new Node(node.v, distance[node.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}