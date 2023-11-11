
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static private int n,q;
    static private ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static private class Node{
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Node(v2,cost));
            list.get(v2).add(new Node(v1,cost));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(findVideo(k, v)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int findVideo(int k, int v) {
        Queue<Node> q = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        q.add(new Node(v, Integer.MAX_VALUE));
        check[v] = true;

        int cnt = 0, linkMinCost = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            ArrayList<Node> link = list.get(cur.v);

            for(int i=0; i<link.size(); i++) {
                if(check[link.get(i).v]) continue;
                linkMinCost = Math.min(link.get(i).cost, cur.cost);
                if(linkMinCost>=k) {
                    check[link.get(i).v] = true;
                    cnt++;
                    q.add(new Node(link.get(i).v,linkMinCost));
                }
            }
        }
        return cnt;
    }
}