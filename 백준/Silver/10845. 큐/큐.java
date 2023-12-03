
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

            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
                continue;
            } else if(command.equals("pop")) {
                if(!q.isEmpty()) {
                    sb.append(q.poll());
                } else {
                    sb.append("-1");
                }
            } else if(command.equals("size")) {
                sb.append(q.size());
            } else if(command.equals("empty")) {
                if(q.isEmpty()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else if (command.equals("front")) {
                if(!q.isEmpty()) {
                    sb.append(q.getFirst());
                } else {
                    sb.append("-1");
                }
            } else {
                if(!q.isEmpty()) {
                    sb.append(q.getLast());
                } else {
                    sb.append("-1");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}