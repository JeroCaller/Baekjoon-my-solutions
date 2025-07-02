import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
        String[] nk = br.readLine().split(" ");
        final int N = Integer.parseInt(nk[0]);
        final int K = Integer.parseInt(nk[1]);

        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            before.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < before.size() - 1; ++j) {
                after.add(before.get(j + 1) - before.get(j));
            }
            before.clear();
            before.addAll(after);
            after.clear();
        }

        StringBuilder stringBuilder = new StringBuilder();
        before.forEach(number -> {
            stringBuilder.append(number)
                .append(",");
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        bw.write(stringBuilder.toString());
    }
}