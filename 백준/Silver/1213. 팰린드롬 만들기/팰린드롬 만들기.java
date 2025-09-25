import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
        String input = br.readLine();
        Map<Character, Integer> alphabetCounter = new HashMap<>();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); ++i) {
            char token = input.charAt(i);

            if (alphabetCounter.containsKey(token)) {
                alphabetCounter.put(token, alphabetCounter.get(token) + 1);
            } else {
                alphabetCounter.put(token, 1);
            }
        }

        int oddCounter = 0;
        Character oddChar = null;

        for (Map.Entry<Character, Integer> entry : alphabetCounter.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                ++oddCounter;
                oddChar = entry.getKey();
            }
        }

        if (oddCounter > 1) {
            bw.write("I'm Sorry Hansoo");
            return;
        }

        if (oddChar != null) {
            if (alphabetCounter.get(oddChar) == 1) {
                alphabetCounter.remove(oddChar);
            } else {
                alphabetCounter.put(oddChar, alphabetCounter.get(oddChar) - 1);
            }

            deque.offer(oddChar);
        }

        Map.Entry<Character, Integer> entry;
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(alphabetCounter.entrySet());
        entryList.sort((e1, e2) ->
            e2.getKey().compareTo(e1.getKey())
        );

        while (!entryList.isEmpty()) {
            entry = entryList.remove(0);

            while (entry.getValue() > 0) {
                deque.offer(entry.getKey());
                deque.offerFirst(entry.getKey());
                entry.setValue(entry.getValue() - 2);
            }
        }

        while (!deque.isEmpty()) {
            bw.write(String.valueOf(deque.poll()));
        }
    }
}
