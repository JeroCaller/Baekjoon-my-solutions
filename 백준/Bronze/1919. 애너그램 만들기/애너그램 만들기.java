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
        String firstWord = br.readLine();
        String secondWord = br.readLine();
        Map<Character, Integer> firstWordChar = getAlphabetMap(firstWord);
        Map<Character, Integer> secondWordChar = getAlphabetMap(secondWord);

        int answer = 0;
        secondWordChar.forEach((secondKey, secondValue) -> {
            if (firstWordChar.containsKey(secondKey)) {
                firstWordChar.replace(
                    secondKey,
                    Math.abs(firstWordChar.get(secondKey) - secondValue)
                );
            } else {
                firstWordChar.put(secondKey, secondValue);
            }
        });
        for (Map.Entry<Character, Integer> entry : firstWordChar.entrySet()) {
            answer += entry.getValue();
        }
        bw.write(String.valueOf(answer));
    }

    public static Map<Character, Integer> getAlphabetMap(String word) {
        Map<Character, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < word.length(); ++i) {
            char oneChar = word.charAt(i);
            if (alphabetMap.containsKey(oneChar)) {
                alphabetMap.put(oneChar, alphabetMap.get(oneChar) + 1);
            } else {
                alphabetMap.put(oneChar, 1);
            }
        }

        return alphabetMap;
    }

}