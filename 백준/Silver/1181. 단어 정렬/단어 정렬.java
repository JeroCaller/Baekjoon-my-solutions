import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        final int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            String nextWord = br.readLine();
            if (words.contains(nextWord)) {
                continue;
            }
            words.add(nextWord);
        }

        words.sort((a, b) -> {
            int diff = a.length() - b.length();
            if (diff == 0) {
                return a.compareTo(b);
            }
            return diff;
        });

        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }
    }
}