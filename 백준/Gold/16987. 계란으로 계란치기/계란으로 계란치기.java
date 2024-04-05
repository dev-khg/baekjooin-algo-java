import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Egg[] eggs;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int left, int broken) {
        if (left == eggs.length) {
            answer = Math.max(answer, broken);
            return;
        }

        if (eggs[left].isBroken() || broken == eggs.length - 1) {
            dfs(left + 1, broken);
            return;
        }

        Egg leftHand = eggs[left];

        for (int i = 0; i < eggs.length; i++) {
            if (i == left) continue;

            Egg rightHand = eggs[i];

            if (!rightHand.isBroken()) {
                leftHand.punch(rightHand);
                int brokenCount = 0;

                if (leftHand.isBroken()) {
                    brokenCount++;
                }
                if (rightHand.isBroken()) {
                    brokenCount++;
                }

                dfs(left + 1, broken + brokenCount);
                leftHand.rollbackPunch(rightHand);
            }
        }
    }

    static class Egg {
        private int S;
        private int W;

        public Egg(int s, int w) {
            S = s;
            W = w;
        }

        public void punch(Egg egg) {
            this.S -= egg.W;
            egg.S -= this.W;
        }

        public void rollbackPunch(Egg egg) {
            this.S += egg.W;
            egg.S += this.W;
        }

        public boolean isBroken() {
            return S <= 0;
        }
    }
}