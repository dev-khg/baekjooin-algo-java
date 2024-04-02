import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] lis = new int[N];
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = nums[0];
        int lengthLis = 1;

        for (int i = 1; i < N; i++) {
            int target = nums[i];

            if (lis[lengthLis - 1] < target) {
                lengthLis++;
                lis[lengthLis - 1] = target;
            } else {
                int left = 0, right = lengthLis;

                while (left < right) {
                    int mid = (left + right) >>> 1;

                    if (lis[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                lis[left] = target;
            }
        }

        System.out.println(lengthLis);
    }

}