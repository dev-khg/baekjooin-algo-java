
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robots = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;
        while (true) {
            level++;

            rotationBeltAndRobot(belt, robots);

            moveRobot(belt, robots);

            if(belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }

            int durability = countDurability(belt);

            if(durability >= K) {
                break;
            }
        }
        System.out.println(level);
    }

    private static int countDurability(int[] belt) {
        int count = 0;
        for (int i = 0; i < belt.length; i++) {
            if(belt[i] == 0) count++;
        }
        return count;
    }

    private static void moveRobot(int[] belt, boolean[] robots) {
        robots[robots.length - 1] = false;
        for (int i = robots.length - 1; i > 0; i--) {
            if(!robots[i] && robots[i - 1] && belt[i] > 0) {
                robots[i] = true;
                robots[i - 1] = false;
                belt[i] -= 1;
            }
        }
    }

    static void rotationBeltAndRobot(int[] belt, boolean[] robots) {
        int last = belt[belt.length - 1];
        for (int i = belt.length - 1; i >= 1; i--) {
            belt[i] = belt[i - 1];
        }
        for (int i = robots.length - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = false;
        robots[robots.length - 1] = false;
        belt[0] = last;
    }
}