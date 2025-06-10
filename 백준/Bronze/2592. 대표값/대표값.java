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
        final int N = 10;
        Map<Integer, Integer> modeTable = new HashMap<>();
        int total = 0;
        for (int i = 0; i < N; ++i) {
            int number = Integer.parseInt(br.readLine());
            total += number;
            if (modeTable.containsKey(number)) {
                modeTable.put(number, modeTable.get(number) + 1);
            } else {
                modeTable.put(number, 1);
            }
        }

        int mode = 0;
        int frequency = 0;
        for (Map.Entry<Integer, Integer> entry : modeTable.entrySet()) {
            if (entry.getValue() > frequency) {
                mode = entry.getKey();
                frequency = entry.getValue();
            }
        }
        bw.write(String.valueOf(total / N));
        bw.newLine();
        bw.write(String.valueOf(mode));
    }

}