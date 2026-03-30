import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, m, r;
    private static int count = 0;
    private static int[] visited;
    private static final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

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
        r = Integer.parseInt(inputs[2]);
        visited = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            adjacentMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);

            adjacentMap.get(u).add(v);
            adjacentMap.get(v).add(u);
        }

        for (int key : adjacentMap.keySet()) {
            adjacentMap.get(key).sort((n1, n2) -> n2 - n1);
        }

        dfs(r);

        for (int i = 1; i < visited.length; ++i) {
            bw.write(String.valueOf(visited[i]));
            bw.newLine();
        }
    }

    private static void dfs(int node) {
        visited[node] = ++count;

        for (int nextNode : adjacentMap.get(node)) {
            if (visited[nextNode] != 0) {
                continue;
            }

            dfs(nextNode);
        }
    }
}
