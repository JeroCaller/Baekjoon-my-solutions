import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<List<Integer>> ALL_RESULTS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int M = Integer.parseInt(inputs[1]);

        findAnswers(new ArrayList<>(), N, M);

        for (List<Integer> oneResult : ALL_RESULTS) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }

    private static void findAnswers(List<Integer> oneResult, int n, int r) {
        if (oneResult.size() == r) {
            ALL_RESULTS.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!oneResult.isEmpty() && oneResult.get(oneResult.size() - 1) > i) {
                continue;
            }

            oneResult.add(i);
            findAnswers(oneResult, n, r);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
