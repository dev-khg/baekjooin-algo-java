
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int count = 0;
        int[] arr = new int[10];

        int len = input.length();

        for (int i = 0; i < len; i++) {
            int num = input.charAt(i) - '0';

            if(num == 6 || num == 9) {
                if(arr[6] > 0) {
                    arr[6]--;
                } else if(arr[9] > 0) {
                    arr[9]--;
                } else {
                    count++;
                    for (int j = 0; j < 10; j++) {
                        arr[j]++;
                    }
                    arr[6]--;
                }
            } else {
                if(arr[num] > 0) {
                    arr[num]--;
                } else{
                    count++;
                    for (int j = 0; j < 10; j++) {
                        arr[j]++;
                    }
                    arr[num]--;
                }
            }
        }

        System.out.println(count);
    }
}