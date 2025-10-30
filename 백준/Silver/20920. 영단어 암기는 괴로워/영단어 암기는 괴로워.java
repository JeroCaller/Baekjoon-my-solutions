import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        final Map<String, Integer> wordCounterMap = new HashMap<>();
        final List<String> wordList = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }

            if (wordCounterMap.containsKey(word)) {
                wordCounterMap.put(word, wordCounterMap.get(word) + 1);
            } else {
                wordCounterMap.put(word, 1);
                wordList.add(word);
            }
        }

        wordList.sort((e1, e2) -> {
            int countDiff = wordCounterMap.get(e2) - wordCounterMap.get(e1);

            if (countDiff != 0) {
                return countDiff;
            }

            if (e1.length() != e2.length()) {
                return e2.length() - e1.length();
            }

            return e1.compareTo(e2);
        });

        for (String word : wordList) {
            bw.write(word);
            bw.newLine();
        }
    }
}
