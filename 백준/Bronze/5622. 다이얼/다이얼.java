import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        String[] input = br.readLine().split("");

        final Map<Integer, List<String>> numberAlphaTable =
            new HashMap<>();
        numberAlphaTable.put(2, Arrays.asList("A", "B", "C"));
        numberAlphaTable.put(3, Arrays.asList("D", "E", "F"));
        numberAlphaTable.put(4, Arrays.asList("G", "H", "I"));
        numberAlphaTable.put(5, Arrays.asList("J", "K", "L"));
        numberAlphaTable.put(6, Arrays.asList("M", "N", "O"));
        numberAlphaTable.put(7, Arrays.asList("P", "Q", "R", "S"));
        numberAlphaTable.put(8, Arrays.asList("T", "U", "V"));
        numberAlphaTable.put(9, Arrays.asList("W", "X", "Y", "Z"));

        final Map<String, Integer> reversedTable = new HashMap<>();
        numberAlphaTable.entrySet().forEach(entry -> {
            entry.getValue().forEach(value -> {
                reversedTable.put(value, entry.getKey());
            });
        });

        int result = 0;
        for (String alpha : input) {
            result += reversedTable.get(alpha) + 1;
        }

        bw.write(String.valueOf(result));
    }
}