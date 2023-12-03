
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                q.addFirst(num);
                continue;
            } else if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                q.addLast(num);
                continue;
            } else if (command.equals("pop_front")) {
                sb.append(q.isEmpty() ? -1 : q.removeFirst());
            } else if (command.equals("pop_back")) {
                sb.append(q.isEmpty() ? -1 : q.removeLast());
            } else if (command.equals("size")) {
                sb.append(q.size());
            } else if (command.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.getFirst());
            } else {
                sb.append(q.isEmpty() ? -1 : q.getLast());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}