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
        final int K = Integer.parseInt(firstLine[0]);
        final int L = Integer.parseInt(firstLine[1]);
        String[] waitList = new String[L];
        Map<String, Integer> waitPosition = new HashMap<>();

        for (int i = 0; i < L; ++i) {
            String input = br.readLine();

            if (waitPosition.containsKey(input)) {
                waitList[waitPosition.get(input)] = null;
            }

            waitPosition.put(input, i);
            waitList[i] = input;
        }

        int count = 0;
        int index = 0;

        while (count < K && index < L) {
            if (waitList[index] == null) {
                ++index;
                continue;
            }

            bw.write(waitList[index++]);
            bw.newLine();

            ++count;
        }
    }
}
