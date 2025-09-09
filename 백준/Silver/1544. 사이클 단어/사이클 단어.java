import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
        final Set<String> wordSet = new HashSet<>();
        Queue<Character> characterQueue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String input;
        boolean hasElementInSet = false;

        for (int i = 0; i < N; ++i) {
            input = br.readLine();

            for (int j = 0; j < input.length(); ++j) {
                characterQueue.offer(input.charAt(j));
            }

            for (int j = 0; j < input.length(); ++j) {
                characterQueue.forEach(stringBuilder::append);

                if (wordSet.contains(stringBuilder.toString())) {
                    hasElementInSet = true;
                    break;
                }

                characterQueue.offer(characterQueue.poll());
                stringBuilder.setLength(0);  // reset
            }

            if (!hasElementInSet) {
                wordSet.add(input);
            }

            characterQueue.clear();
            stringBuilder.setLength(0);
            hasElementInSet = false;
        }

        bw.write(String.valueOf(wordSet.size()));
    }
}
