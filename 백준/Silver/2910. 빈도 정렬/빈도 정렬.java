import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
        final int C = Integer.parseInt(firstLine[1]);
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> counterMap = new HashMap<>();
        Map<Integer, Integer> firstAppearenceMap = new HashMap<>();
        int appearCount = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            numbers.add(num);

            if (counterMap.containsKey(num)) {
                counterMap.put(num, counterMap.get(num) + 1);
            } else {
                counterMap.put(num, 1);
            }

            if (!firstAppearenceMap.containsKey(num)) {
                firstAppearenceMap.put(num, appearCount);
                ++appearCount;
            }
        }

        numbers.sort((n1, n2) -> {
            int counterDiff = counterMap.get(n2) - counterMap.get(n1);

            if (counterDiff != 0) {
                return counterDiff;
            }

            return firstAppearenceMap.get(n1) - firstAppearenceMap.get(n2);
        });

        for (int num : numbers) {
            bw.write(num + " ");
        }
    }
}
