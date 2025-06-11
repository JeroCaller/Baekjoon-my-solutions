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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String[] inputs = br.readLine().split(" ");
            if (inputs[0].length() != inputs[1].length()) {
                bw.write("Impossible");
                bw.newLine();
                continue;
            }

            Map<Character, Integer> leftWord = getCountOfAlphabet(inputs[0]);
            Map<Character, Integer> rightWord = getCountOfAlphabet(inputs[1]);
            rightWord.forEach((key, value) -> {
                if (leftWord.containsKey(key)) {
                    leftWord.put(key, leftWord.get(key) - value);
                    if (leftWord.get(key) == 0) {
                        leftWord.remove(key);
                    }
                } else {
                    leftWord.put(key, value);
                }
            });
            if (leftWord.isEmpty()) {
                bw.write("Possible");
            } else {
                bw.write("Impossible");
            }
            bw.newLine();
        }
    }

    public static Map<Character, Integer> getCountOfAlphabet(String source) {
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < source.length(); ++i) {
            char currentChar = source.charAt(i);
            if (alphabetMap.containsKey(currentChar)) {
                alphabetMap.put(currentChar, alphabetMap.get(currentChar) + 1);
            } else {
                alphabetMap.put(currentChar, 1);
            }
        }
        return alphabetMap;
    }
}