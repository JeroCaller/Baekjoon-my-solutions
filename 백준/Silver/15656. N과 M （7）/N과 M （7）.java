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

        Executer executer = new Executer(array, M);
        executer.execute();

        for (List<Integer> oneResult : executer.getAllResults()) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }
}

class Executer {
    private List<List<Integer>> allResults = new ArrayList<>();
    private final int[] array;
    private final int r;

    public Executer(int[] array, int r) {
        this.array = array;
        this.r = r;
    }

    public List<List<Integer>> getAllResults() {
        return allResults;
    }

    public void execute() {
        logic(new ArrayList<>());
    }

    private void logic(List<Integer> oneResult) {
        if (oneResult.size() == r) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            oneResult.add(array[i]);
            logic(oneResult);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
