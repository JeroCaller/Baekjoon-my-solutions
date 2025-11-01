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
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[N];

        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);

        Logic logic = new Logic(array, M);
        logic.execute();

        for (List<Integer> oneResult : logic.getAllResults()) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }
}

class Logic {
    private final List<List<Integer>> allResults = new ArrayList<>();
    private final int[] array;
    private final Integer r;

    public Logic(int[] array, int r) {
        this.array = array;
        this.r = r;
    }

    public List<List<Integer>> getAllResults() {
        return allResults;
    }

    public void execute() {
        _execute(new ArrayList<>(), 0);
    }

    private void _execute(List<Integer> oneResult, int startIdx) {
        if (oneResult.size() == r) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            if (i < startIdx) {
                continue;
            }

            oneResult.add(array[i]);
            _execute(oneResult, i);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
