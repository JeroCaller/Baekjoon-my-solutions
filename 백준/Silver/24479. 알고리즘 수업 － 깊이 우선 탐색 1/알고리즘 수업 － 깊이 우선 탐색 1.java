import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<List<Integer>> graphMap = new ArrayList<>();
    private static int[] visited;
    private static int count = 1;

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
        final int R = Integer.parseInt(conditions[2]);
        visited = new int[N + 1];

        for (int i = 0; i <= N; ++i) {
            graphMap.add(new ArrayList<>());
        }

        for (int i = 0; i < M; ++i) {
            String[] inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            graphMap.get(u).add(v);
            graphMap.get(v).add(u);
        }

        for (List<Integer> valueList : graphMap) {
            Collections.sort(valueList);
        }

        visited[R] = count;
        dfs(R);

        for (int i = 1; i < visited.length; ++i) {
            bw.write(String.valueOf(visited[i]));
            bw.newLine();
        }
    }

    private static void dfs(int start) {
        if (graphMap.get(start).isEmpty()) return;

        for (int node : graphMap.get(start)) {
            if (visited[node] != 0) continue;
            visited[node] = ++count;
            dfs(node);
        }
    }
}
