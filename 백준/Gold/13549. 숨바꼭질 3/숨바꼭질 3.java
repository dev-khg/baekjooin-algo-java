
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();

            int back = node.point - 1;
            int front = node.point + 1;
            int teleport = 2 * node.point;

            if(isInRange(teleport) && visited[teleport] > node.cost) {
                visited[teleport] = node.cost;
                q.offer(new Node(teleport, node.cost));
            }
            if(isInRange(back) && visited[back] > node.cost + 1) {
                visited[back] = node.cost + 1;
                q.offer(new Node(back, node.cost + 1));
            }
            if(isInRange(front) && visited[front] > node.cost + 1) {
                visited[front] = node.cost + 1;
                q.offer(new Node(front, node.cost + 1));
            }
        }

        System.out.println(visited[K] - 1);
    }

    private static boolean isInRange(int point) {
        return point >= 0 && point <= 100000;
    }

    static class Node {
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }
}