import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
    private static int n, m, r;
    private static int[] visits;

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
        visits = new int[n + 1];

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

        for (int i = 1; i <= n; ++i) {
            Collections.sort(adjacentMap.get(i));
        }

        bfs();

        for (int i = 1; i < visits.length; ++i) {
            bw.write(String.valueOf(visits[i]));
            bw.newLine();
        }
    }

    private static void bfs() {
        final Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(r);
        visits[r] = count++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nextNode : adjacentMap.get(node)) {
                if (visits[nextNode] != 0) {
                    continue;
                }

                queue.offer(nextNode);
                visits[nextNode] = count++;
            }
        }
    }
}
