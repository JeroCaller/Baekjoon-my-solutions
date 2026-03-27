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
    private static final List<List<Integer>> allResults = new ArrayList<>();
    private static int[] array;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        search(new ArrayList<>());

        for (List<Integer> oneResult : allResults) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
        }
    }

    private static void search(List<Integer> oneResult) {
        if (oneResult.size() == m) {
            allResults.add(new ArrayList<>(oneResult));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (i > 0 && !visited[i - 1] && array[i - 1] == array[i]) {
                continue;
            }

            visited[i] = true;
            oneResult.add(array[i]);
            search(oneResult);
            oneResult.remove(oneResult.size() - 1);
            visited[i] = false;
        }
    }
}
