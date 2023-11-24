
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        int total = Integer.parseInt(br.readLine());
        int lt = 0, rt = total, mid = 0;
        int answer = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;

            int possible = isPossible(mid, money, total);
            if (possible != Integer.MAX_VALUE) {
                answer = possible;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static int isPossible(int max, int[] money, int total) {
        int sum = 0;
        int maxValue = 0;
        for (int i = 0; i < money.length; i++) {
            sum += Math.min(max, money[i]);
            maxValue = Math.max(Math.min(max, money[i]), maxValue);
            if(sum > total) {
                return Integer.MAX_VALUE;
            }
        }
        return maxValue;
    }
}