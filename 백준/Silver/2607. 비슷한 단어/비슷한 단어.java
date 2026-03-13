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
        final Map<Character, Integer> originCharMap = new HashMap<>();
        Map<Character, Integer> copiedMap;
        int count = 0;

        outer : for (int i = 0; i < N; ++i) {
            String input = br.readLine();

            if (i == 0) {
                fillMap(originCharMap, input, true);
                continue;
            }

            copiedMap = new HashMap<>(originCharMap);
            fillMap(copiedMap, input, false);

            int notZeroCount = 0;
            int sum = 0;

            for (char key : copiedMap.keySet()) {
                int mapValue = copiedMap.get(key);

                if (Math.abs(mapValue) > 1 || notZeroCount > 2) {
                    continue outer;
                }

                if (mapValue != 0) {
                    notZeroCount++;
                    sum += mapValue;
                }
            }

            if (notZeroCount <= 2 && Math.abs(sum) <= 1) {
                ++count;
            }
        }

        bw.write(String.valueOf(count));
    }

    private static void insertIntoMap(Map<Character, Integer> map, char key, boolean increase) {
        if (map.containsKey(key)) {
            if (increase) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, map.get(key) - 1);
            }
        } else {
            if (increase) {
                map.put(key, 1);
            } else {
                map.put(key, -1);
            }
        }
    }

    private static void fillMap(Map<Character, Integer> map, String word, boolean increase) {
        for (int j = 0; j < word.length(); ++j) {
            char key = word.charAt(j);
            insertIntoMap(map, key, increase);
        }
    }
}
