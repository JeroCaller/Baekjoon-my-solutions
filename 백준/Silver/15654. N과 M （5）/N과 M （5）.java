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
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);

        Permutation permutation = new Permutation(numbers, M);

        for (List<Integer> oneResult : permutation.getAllCases()) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }
}

class Permutation {
    private final List<List<Integer>> ALL_RESULTS = new ArrayList<>();
    private int[] array;
    private int r;

    public Permutation(int[] array, int r) {
        this.array = array;
        this.r = r;
    }

    public List<List<Integer>> getAllCases() {
        execute(new ArrayList<>());
        return ALL_RESULTS;
    }

    private void execute(List<Integer> oneResult) {
        if (oneResult.size() == r) {
            ALL_RESULTS.add(new ArrayList<>(oneResult));
            return;
        }

        for (int num : array) {
            if (oneResult.contains(num)) {
                continue;
            }

            oneResult.add(num);
            execute(oneResult);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
