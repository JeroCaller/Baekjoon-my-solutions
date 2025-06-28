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
        String source = br.readLine().toUpperCase();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < source.length(); ++i) {
            char currentChar = source.charAt(i);
            if (charMap.containsKey(currentChar)) {
                charMap.put(currentChar, charMap.get(currentChar) + 1);
            } else {
                charMap.put(currentChar, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());
        char answer;
        if (entryList.size() > 1 && entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
            answer = '?';
        } else {
            answer = entryList.get(0).getKey();
        }

        bw.write(answer);
    }
}