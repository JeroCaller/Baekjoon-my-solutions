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
        String source = br.readLine();
        final int M = source.length();
        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i <= 9; ++i) {
            table.put(i, 0);
        }

        for (int i = 0; i < M; ++i) {
            int num = source.charAt(i) - '0';

            if (num == 6 || num == 9) {
                if (table.get(6) <= table.get(9)) {
                    table.put(6, table.get(6) + 1);
                } else {
                    table.put(9, table.get(9) + 1);
                }
            } else {
                table.put(num, table.get(num) + 1);
            }
        }

        int max = 0;
        for (int value : table.values()) {
            if (max < value) {
                max = value;
            }
        }

        bw.write(String.valueOf(max));
    }
}
