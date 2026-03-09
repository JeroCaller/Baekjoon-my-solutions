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

    private static final List<List<Integer>> allResults = new ArrayList<>();
    private static int n, m;
    private static int[] array;
    private static boolean[] visisted;
    
    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] conditions = br.readLine().split(" ");
        n = Integer.parseInt(conditions[0]);
        m = Integer.parseInt(conditions[1]);
        array = new int[n];
        visisted = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        findAllCases(new ArrayList<>(), 0);

        for (List<Integer> oneResult : allResults) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }

    private static void findAllCases(List<Integer> oneResult, int startIdx) {
        if (oneResult.size() == m) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = startIdx; i < n; ++i) {
            if (i > 0 && array[i] == array[i - 1] && !visisted[i - 1]) {
                continue;
            }

            oneResult.add(array[i]);
            visisted[i] = true;
            findAllCases(oneResult, i);
            oneResult.remove(oneResult.size() - 1);
            visisted[i] = false;
        }
    }
}
