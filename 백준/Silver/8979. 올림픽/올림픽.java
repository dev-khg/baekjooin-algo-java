
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
        if(countries[0].id == K) {
            System.out.println(rank);
            return;
        }
        for (int i = 1; i < countries.length; i++) {
            if (!countries[i].isSame(countries[i - 1])) {
                 rank = i + 1;
            }

            if(countries[i].id == K) {
                break;
            }
        }

        System.out.println(rank);
    }

    static int getNextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Country {
        int id;
        int gold;
        int silver;
        int bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        private boolean isSame(Country country) {
            return country.gold == this.gold && country.silver == this.silver
                    && country.bronze == this.bronze;
        }
    }
}