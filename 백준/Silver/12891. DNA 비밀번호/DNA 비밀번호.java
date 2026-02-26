import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final int[] constraints = new int[4];
    private static final int[] counters = new int[4];
    private static final char[] alphabets = {'A', 'C', 'G', 'T'};
    private static int s, p;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] conditions = br.readLine().split(" ");
        s = Integer.parseInt(conditions[0]);
        p = Integer.parseInt(conditions[1]);
        final String dna = br.readLine();
        conditions = br.readLine().split(" ");
        int answer = 0;

        for (int i = 0; i < alphabets.length; ++i) {
            constraints[i] = Integer.parseInt(conditions[i]);
        }

        for (int i = 0; i < p; ++i) {
            count(charToIdx(dna.charAt(i)), true);
        }

        if (check()) {
            ++answer;
        }

        for (int i = 1; i + p - 1 < s; ++i) {
            count(charToIdx(dna.charAt(i - 1)), false);
            count(charToIdx(dna.charAt(i + p - 1)), true);

            if (check()) {
                ++answer;
            }
        }

        bw.write(String.valueOf(answer));
    }

    private static int charToIdx(char alp) {
        for (int i = 0; i < alphabets.length; ++i) {
            if (alp == alphabets[i]) {
                return i;
            }
        }

        return -1;
    }

    private static void count(int idx, boolean increase) {
        if (increase) {
            counters[idx]++;
        } else {
            counters[idx]--;
        }
    }

    private static boolean check() {
        for (int i = 0; i < alphabets.length; ++i) {
            if (constraints[i] > counters[i]) {
                return false;
            }
        }

        return true;
    }
}
