import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        int[] array = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);

        Combination combination = new Combination(array, M);
        combination.execute();

        for (List<Integer> oneResult : combination.getAllResults()) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }
}

class Combination {
    private final List<List<Integer>> allResults = new ArrayList<>();
    private final int[] array;
    private final int r;

    public Combination(int[] array, int r) {
        this.array = array;
        this.r = r;
    }

    public List<List<Integer>> getAllResults() {
        return allResults;
    }

    public void execute() {
        logic(new ArrayList<>(), 0);
    }

    private void logic(List<Integer> oneResult, int startIdx) {
        if (oneResult.size() == r) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = startIdx; i < array.length; ++i) {
            oneResult.add(array[i]);
            logic(oneResult, i + 1);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}