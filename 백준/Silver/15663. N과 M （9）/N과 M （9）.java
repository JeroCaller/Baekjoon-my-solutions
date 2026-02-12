import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<List<Integer>> allResults = new ArrayList<>();
    private static int[] array;
    private static boolean[] visited;
    private static final Set<List<Integer>> hasTheList = new HashSet<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int M = Integer.parseInt(conditions[1]);
        array = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        permutation(new ArrayList<>(), M);

        for (List<Integer> oneResult : allResults) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }

    private static void permutation(List<Integer> oneResult, int r) {
        if (oneResult.size() == r && !hasTheList.contains(oneResult)) {
            allResults.add(new ArrayList<>(oneResult));
            hasTheList.add(oneResult);
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            oneResult.add(array[i]);
            permutation(oneResult, r);
            oneResult.remove(oneResult.size() - 1);
            visited[i] = false;
        }
    }
}
