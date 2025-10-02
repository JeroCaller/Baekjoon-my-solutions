import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
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
        final int M = Integer.parseInt(inputs[1]);
        final Permutation permutation = new Permutation(N, M);

        permutation.executePermutation();

        for (List<Integer> oneList : permutation.getResults()) {
            for (int number : oneList) {
                bw.write(number + " ");
            }

            bw.newLine();
        }
    }
}

class Permutation {
    private int n;
    private int m;
    private final List<List<Integer>> series = new LinkedList<>();
    private boolean[] visited;

    public Permutation(int n, int m) {
        this.n = n;
        this.m = m;
        this.visited = new boolean[n + 1];
    }

    public void executePermutation() {
        permutation(new LinkedList<>());
    }

    private void permutation(List<Integer> oneList) {
        if (oneList.size() == m) {
            series.add(new LinkedList<>(oneList));
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                oneList.add(i);
                visited[i] = true;
                permutation(oneList);
                visited[i] = false;
                oneList.remove(oneList.size() - 1);
            }
        }
    }

    public List<List<Integer>> getResults() {
        return series;
    }
}
