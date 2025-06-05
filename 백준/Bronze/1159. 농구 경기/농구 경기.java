import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Integer> nameTable = new TreeMap<>();

        for (int i = 0; i < N; ++i) {
            String firstAlphabetOfName = br.readLine().substring(0, 1);
            if (!nameTable.containsKey(firstAlphabetOfName)) {
                nameTable.put(firstAlphabetOfName, 1);
            } else {
                nameTable.put(
                    firstAlphabetOfName,
                    nameTable.get(firstAlphabetOfName) + 1
                );
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        nameTable.forEach((key, value) -> {
            if (value >= 5) {
                stringBuilder.append(key);
            }
        });

        if (stringBuilder.toString().isEmpty()) {
            bw.write("PREDAJA");
            return;
        }
        bw.write(stringBuilder.toString());
    }
}