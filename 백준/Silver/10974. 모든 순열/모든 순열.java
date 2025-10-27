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
        final int N = Integer.parseInt(br.readLine());
        Permutation permutation = new Permutation(N);

        for (List<Integer> oneResult : permutation.getResult()) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }
}

class Permutation {
    private final List<List<Integer>> allResults = new ArrayList<>();
    private boolean[] isVisited;
    private Integer n;

    public Permutation(int n) {
        this.n = n;
        isVisited = new boolean[n + 1];
    }

    public List<List<Integer>> getResult() {
        execute(new ArrayList<>());
        return allResults;
    }

    private void execute(List<Integer> oneResult) {
        if (oneResult.size() == n) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!isVisited[i]) {
                oneResult.add(i);
                isVisited[i] = true;
                execute(oneResult);
                oneResult.remove(oneResult.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}