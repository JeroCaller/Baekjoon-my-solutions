import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Map<Character, Integer> constraints = new HashMap<>();
    private static final Map<Character, Integer> counters = new HashMap<>();
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
            constraints.put(alphabets[i], Integer.parseInt(conditions[i]));
            counters.put(alphabets[i], 0);
        }

        for (int i = 0; i < p; ++i) {
            insertIntoMap(counters, dna.charAt(i), true);
        }

        if (check()) {
            ++answer;
        }

        for (int i = 1; i + p - 1 < s; ++i) {
            insertIntoMap(counters, dna.charAt(i - 1), false);
            insertIntoMap(counters, dna.charAt(i + p - 1), true);

            if (check()) {
                ++answer;
            }
        }

        bw.write(String.valueOf(answer));
    }

    private static void insertIntoMap(Map<Character, Integer> map, char key, boolean increase) {
        if (map.containsKey(key)) {
            if (increase) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
    }

    private static boolean check() {
        for (char alp : counters.keySet()) {
            if (constraints.get(alp) > counters.get(alp)) {
                return false;
            }
        }

        return true;
    }
}
