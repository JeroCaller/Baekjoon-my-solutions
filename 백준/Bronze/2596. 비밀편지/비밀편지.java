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
        Map<String, String> table = new HashMap<>();
        table.put("000000", "A");
        table.put("001111", "B");
        table.put("010011", "C");
        table.put("011100", "D");
        table.put("100110", "E");
        table.put("101001", "F");
        table.put("110101", "G");
        table.put("111010", "H");

        final int N = Integer.parseInt(br.readLine());
        String source = br.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 6 * N; i = i + 6) {
            String subStr = source.substring(i, i + 6);

            if (table.containsKey(subStr)) {
                stringBuilder.append(table.get(subStr));
                continue;
            }

            int oneCounter = 0;

            for (Map.Entry<String, String> entry : table.entrySet()) {
                oneCounter = 0;

                int diffBin = Integer.parseInt(subStr, 2) ^
                    Integer.parseInt(entry.getKey(), 2);
                String diffBinStr = Integer.toBinaryString(diffBin);

                for (int j = 0; j < diffBinStr.length(); ++j) {
                    if (diffBinStr.charAt(j) == '1') {
                        ++oneCounter;
                    }
                }

                if (oneCounter == 1) {
                    stringBuilder.append(entry.getValue());
                    break;
                }
            }

            if (oneCounter > 1) {
                bw.write(String.valueOf((i / 6) + 1));
                return;
            }
        }

        bw.write(stringBuilder.toString());
    }
}