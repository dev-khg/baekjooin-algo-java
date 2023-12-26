import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long count = 0;

        for (int i = 0; i < N; i++) {
            int lt = i + 1;
            int rt = N - 1;

            while (lt < rt) {
                int sum = arr[lt] + arr[rt] + arr[i];

                if(sum == 0) {
                    int lCnt = 1;
                    int rCnt = 1;

                    if(arr[lt] == arr[rt]) {
                        int n = rt - lt + 1;
                        count += n * (n - 1) / 2;
                        break;
                    }

                    while(arr[lt] == arr[lt + 1]) {
                        lt += 1;
                        lCnt++;
                    }
                    while (arr[rt] == arr[rt - 1]) {
                        rt -= 1;
                        rCnt++;
                    }

                    count += lCnt * rCnt;
                }

                if(sum > 0) rt--;
                else lt++;
            }
        }
        System.out.println(count);
    }
}