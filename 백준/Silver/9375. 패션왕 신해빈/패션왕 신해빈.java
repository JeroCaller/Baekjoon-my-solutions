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
        final int T = Integer.parseInt(br.readLine());
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                bw.write("0");
                bw.newLine();
                continue;
            }

            int answer = 1;

            for (int j = 0; j < n; ++j) {
                String[] input = br.readLine().split(" ");

                if (countMap.containsKey(input[1])) {
                    countMap.put(input[1], countMap.get(input[1]) + 1);
                } else {
                    countMap.put(input[1], 1);
                }
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                answer *= entry.getValue() + 1;
            }

            bw.write(String.valueOf(answer - 1));
            bw.newLine();
            countMap.clear();
        }
    }
}
