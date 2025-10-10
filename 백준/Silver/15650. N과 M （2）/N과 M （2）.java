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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int R = Integer.parseInt(inputs[1]);
        Combination combination = new Combination(N, R);
        List<List<Integer>> results = combination.getResults();

        for (List<Integer> oneResult : results) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }
            bw.newLine();
        }
    }
}

class Combination {

    private final List<List<Integer>> results = new ArrayList<>();
    private int n;
    private int r;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
    }

    public List<List<Integer>> getResults() {
        combination(1, new ArrayList<>());
        return results;
    }

    private void combination(int startNum, List<Integer> oneResult) {
        if (oneResult.size() == r) {
            results.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = startNum; i <= n; ++i) {
            oneResult.add(i);
            combination(i + 1, oneResult);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}