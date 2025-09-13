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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        final Map<Integer, String> numToNameMap = new HashMap<>();
        final Map<String, Integer> nameToNumMap = new HashMap<>();
        String input;

        for (int i = 1; i <= N; ++i) {
            input = br.readLine();
            numToNameMap.put(i, input);
            nameToNumMap.put(input, i);
        }

        int number;

        for (int i = 1; i <= M; ++i) {
            input = br.readLine();

            try {
                number = Integer.parseInt(input);
                bw.write(numToNameMap.get(number));
            } catch (NumberFormatException e) {
                bw.write(String.valueOf(nameToNumMap.get(input)));
            }

            bw.newLine();
        }
    }
}
