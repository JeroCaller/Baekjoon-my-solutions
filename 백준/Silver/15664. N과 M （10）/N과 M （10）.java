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

    private static int n, m;
    private static int[] series;
    private static boolean[] visited;
    private static final List<List<Integer>> allResults = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        series = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            series[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(series);
        search(new ArrayList<>(), 0);

        for (List<Integer> oneResult : allResults) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }

    private static void search(List<Integer> oneResult, int startIdx) {
        if (oneResult.size() == m) {
            allResults.add(new ArrayList<>(oneResult));
        }

        for (int i = startIdx; i < n; ++i) {
            if (visited[i] || ((i > 0) && !visited[i - 1] && series[i - 1] == series[i])) {
                continue;
            }

            visited[i] = true;
            oneResult.add(series[i]);
            search(oneResult, i + 1);
            oneResult.remove(oneResult.size() - 1);
            visited[i] = false;
        }
    }
}
