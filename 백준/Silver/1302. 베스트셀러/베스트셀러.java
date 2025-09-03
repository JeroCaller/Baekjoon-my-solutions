import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, Integer> map = new HashMap<>();
        String input;

        for (int i = 0; i < N; ++i) {
            input = br.readLine();

            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
            .sorted((e1, e2) -> {
                int diff = e2.getValue() - e1.getValue();

                if (diff != 0) {
                    return diff;
                }

                return e1.getKey().compareTo(e2.getKey());
            })
            .collect(Collectors.toList());

        bw.write(entries.get(0).getKey());
    }
}
