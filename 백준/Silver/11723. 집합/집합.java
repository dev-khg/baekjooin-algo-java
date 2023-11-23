import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bitMask = 0;
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    bitMask |= (1 << num);
                    break;
                case "remove":
                    bitMask &= ~(1 << num);
                    break;
                case "check":
                    if ((bitMask & (1 << num)) > 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    bitMask ^= (1 << num);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        bitMask |= (1 << j);
                    }
                    break;
                case "empty":
                    bitMask = 0;
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}