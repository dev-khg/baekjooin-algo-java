
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가로길이
        int M = Integer.parseInt(st.nextToken()); // 세로길이
        int L = Integer.parseInt(st.nextToken()); // 트렘펄린 한변의 길이
        int K = Integer.parseInt(st.nextToken()); // 별똥별의 수

        Point[] stars = new Point[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (isIn(stars[i].x, stars[j].y, L, stars[k])) {
                        count++;
                    }
                }

                answer = Math.max(count, answer);
            }
        }

        System.out.println(K - answer);
    }

    private static boolean isIn(int x, int y, int L, Point star) {
        return star.x >= x && star.y >= y && star.x <= x + L && star.y <= y + L;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}