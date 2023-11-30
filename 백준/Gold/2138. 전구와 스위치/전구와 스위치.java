
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String current = br.readLine();
        String target = br.readLine();
        int length = current.length();
        int[] arr1 = new int[length];
        int[] targetArr = new int[length];
        for (int i = 0; i < length; i++) {
            arr1[i] = current.charAt(i) - '0';
            targetArr[i] = target.charAt(i) - '0';
        }
        int[] arr2 = arr1.clone();
        arr2[0] ^= (1 << 0);
        arr2[1] ^= (1 << 0);
        int count1 = 0;
        int count2 = 1;
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (arr1[i - 1] != targetArr[i - 1]) {
                toggleSwitch(i, arr1);
                count1++;
            }
            if (arr2[i - 1] != targetArr[i - 1]) {
                toggleSwitch(i, arr2);
                count2++;
            }
        }

        if (Arrays.equals(arr1, targetArr)) {
            answer = Math.min(answer, count1);
        }
        if (Arrays.equals(arr2, targetArr)) {
            answer = Math.min(answer, count2);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int[] dx = {-1, 0, 1};

    static void toggleSwitch(int btn, int[] arr) {
        for (int i = 0; i < 3; i++) {
            int nx = btn + dx[i];
            if (nx >= 0 && nx < arr.length) {
                arr[nx] ^= (1 << 0);
            }
        }
    }
}