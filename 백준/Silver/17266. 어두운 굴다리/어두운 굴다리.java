
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] bridge = new int[M];
        for (int i = 0; i < M; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = N, mid;
        int answer = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;

            if (isPossible(bridge, N, mid)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int[] arr, int n, int height) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - height <= start) {
                start = arr[i] + height;
            } else return false;
        }

        return start >= n;
    }
}