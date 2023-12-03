
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();

            sb.append(ac(command, N, arrayStr))
                    .append("\n");
        }

        System.out.println(sb);
    }

    private static String ac(String command, int n, String arrayStr) {
        boolean isReverse = false;

        String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");

        LinkedList<Integer> deque = new LinkedList<>();
        for (String s : split) {
            if (!s.equals("")) deque.offer(Integer.valueOf(s));
        }

        int commandLength = command.length();
        for (int i = 0; i < commandLength; i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                isReverse = !isReverse;
            } else {
                if (deque.isEmpty()) return "error";

                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(isReverse ? deque.removeLast() : deque.removeFirst());
            if (deque.size() != 0)
                sb.append(',');
        }
        sb.append(']');


        return sb.toString();
    }
}