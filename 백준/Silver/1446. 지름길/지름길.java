
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int D;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }

        dis = new int[10001];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        dfs(0);

        System.out.println(dis[D]);
    }

    static void dfs(int v) {
        if (v > D) return;

        if (dis[v + 1] > dis[v] + 1) {
            dis[v + 1] = dis[v] + 1;
        }

        List<Edge> edges = graph.get(v);
        for (Edge edge : edges) {
            if(dis[edge.to] > dis[v] + edge.cost) {
                dis[edge.to] = dis[v] + edge.cost;
            }
        }

        dfs(v + 1);
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}