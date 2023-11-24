
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // BOY
                handleBoy(num, arr);
            } else { // GIRL
                handleGirl(num, arr);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }

    private static void handleGirl(int num, int[] arr) {
        int lt = num - 1, rt = num + 1;
        while (lt >= 1 && rt <= N) {
            if(arr[lt] == arr[rt]) {
                lt--;
                rt++;
            } else break;
        }
        lt++; rt--;

        for(int i = lt; i <= rt; i++) {
            arr[i] ^= 1;
        }
    }

    private static void handleBoy(int num, int[] arr) {
        for(int i = num; i <= N; i += num){
            arr[i] ^= (1 << 0);
        }
    }
}