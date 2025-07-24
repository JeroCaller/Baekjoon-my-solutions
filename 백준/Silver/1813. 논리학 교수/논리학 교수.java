import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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
        Map<Integer, Integer> table = new HashMap<>();
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            if (!table.containsKey(num)) {
                table.put(num, 1);
            } else {
                table.put(num, table.get(num) + 1);
            }
        }

        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getKey().equals(entry.getValue()) && entry.getKey() > maxKey) {
                maxKey = entry.getKey();
            }
        }

        if (maxKey == 0 && table.containsKey(0)) {
            maxKey = -1;
        }

        bw.write(String.valueOf(maxKey));
    }
}
