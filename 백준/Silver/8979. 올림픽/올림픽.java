import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i] = new Country(getNextInt(st), getNextInt(st), getNextInt(st), getNextInt(st));
        }

        Arrays.sort(countries, (a, b) -> {
            if (a.gold == b.gold) {
                if (a.silver == b.silver) {
                    return b.bronze - a.bronze;
                }
                return b.silver - a.silver;
            }
            return b.gold - a.gold;
        });

        int rank = 1;

        for(int i = 0; i < countries.length; i++) {
            if(countries[i].id == K) {
                break;
            }
            rank++;
        }

        System.out.println(rank - 1);
    }

    static int getNextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Country {
        int id;
        int gold;
        int silver;
        int bronze;
        int sum;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.sum = gold * 3 + silver * 2 + bronze;
        }
    }
}