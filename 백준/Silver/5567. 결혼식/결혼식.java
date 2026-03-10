import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, m;
    private static int[] visited;
    private static final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for (int i = 1; i <= n; ++i) {
            adjacentMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            adjacentMap.get(a).add(b);
            adjacentMap.get(b).add(a);
        }

        bw.write(String.valueOf(getAnswer()));
    }

    private static int getAnswer() {
        int count = 0;
        final Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (visited[node] > 0 && visited[node] <= 2) {
                count++;
            } else if (visited[node] > 2) {
                continue;
            }

            for (int nextNode : adjacentMap.get(node)) {
                if (visited[nextNode] != -1) {
                    continue;
                }

                visited[nextNode] = visited[node] + 1;
                queue.offer(nextNode);
            }
        }

        return count;
    }
}
