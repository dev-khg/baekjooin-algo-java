
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(getNextInt(st), getNextInt(st));
        }

        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if(people[i].isSmallThan(people[j])) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static int getNextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Person {
        int rank;
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isSmallThan(Person person) {
            return this.weight < person.weight && this.height < person.height;
        }
    }
}