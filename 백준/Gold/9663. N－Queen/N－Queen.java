import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0, new int[N]);

        System.out.println(answer);
    }

    private static void DFS(int L, int[] arr) {
        if(L == arr.length) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[L] = i;
            if(isPromise(L, arr)) {
                DFS(L + 1, arr);
            }
        }
    }

    private static boolean isPromise(int L, int[] arr) {
        for (int i = 0; i < L; i++) {
            if(arr[i] == arr[L]) return false;
            else if(Math.abs(i - L) == Math.abs(arr[i] - arr[L])) return false;
        }

        return true;
    }
}