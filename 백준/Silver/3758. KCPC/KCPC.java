
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int idx = 0;
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 수
            int k = Integer.parseInt(st.nextToken()); // 문제 수
            int t = Integer.parseInt(st.nextToken()); // 내 팀ID
            int m = Integer.parseInt(st.nextToken()); // 로그개수

            List<Team> teams = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                teams.add(new Team(i, k));
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int no = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(no, idx++, score);
                teams.get(teamId).solve(problem);
            }
            teams.remove(0);

            teams.sort((a, b) -> {
                if(a.getTotalScore() == b.getTotalScore()) {
                    if(a.submitCount == b.submitCount) {
                        return a.lastTime - b.lastTime;
                    }
                    return a.submitCount - b.submitCount;
                }
                return b.getTotalScore() - a.getTotalScore();
            });

            int rank = 1;
            for (Team team : teams) {
                if(team.teamId == t) {
                    System.out.println(rank);
                    break;
                }
                rank++;
            }
        }
    }

    static class Team {
        int teamId;
        int lastTime;
        int submitCount;
        int[] problems;

        public Team(int teamId, int k) {
            this.teamId = teamId;
            this.problems = new int[k + 1];
        }

        public void solve(Problem problem) {
            problems[problem.no] = Math.max(problems[problem.no], problem.score);
            submitCount++;
            lastTime = problem.idx;
        }

        public int getTotalScore() {
            int sum = 0;
            for (int i = 1; i < problems.length; i++) {
                sum += problems[i];
            }
            return sum;
        }
    }

    static class Problem {
        int no;
        int idx;
        int score;

        public Problem(int no, int idx, int score) {
            this.no = no;
            this.idx = idx;
            this.score = score;
        }
    }
}