
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        char pre = '.';
        while (!(input = br.readLine()).equals("end")) {
            pre = '.';
            int sameCount = 0;
            boolean answer = true;
            boolean isContainVowel = false;
            char[] chars = input.toCharArray();

            for (char aChar : chars) {
                boolean vowel = isVowel(aChar);
                if (vowel) isContainVowel = true;
                if (vowel == isVowel(pre)) {
                    sameCount++;
                } else sameCount = 1;

                if (sameCount > 2 || (pre == aChar && (aChar != 'e' && aChar != 'o'))) {
                    answer = false;
                    break;
                }

                pre = aChar;
            }

            if (answer && isContainVowel) {
                sb.append("<").append(input).append("> is acceptable.");
            } else {
                sb.append("<").append(input).append("> is not acceptable.");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
    }
}