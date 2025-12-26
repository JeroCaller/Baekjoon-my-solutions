import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
    private static final Set<Integer> visitedSet = new HashSet<>();

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
        final Set<Integer> inAdjMapSet = new HashSet<>();

        for (int i = 0; i < M; ++i) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);
            addKeyValueToMap(u, v);
            addKeyValueToMap(v, u);
            inAdjMapSet.add(u);
            inAdjMapSet.add(v);
        }

        int count = 0;

        for (int key : adjacentMap.keySet()) {
            if (visitedSet.contains(key)) {
                continue;
            }

            dfs(key);
            ++count;
        }

        bw.write(String.valueOf(count + (N - inAdjMapSet.size())));
    }

    private static void addKeyValueToMap(int key, int value) {
        if (adjacentMap.containsKey(key)) {
            adjacentMap.get(key).add(value);
        } else {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(value);
            adjacentMap.put(key, valueList);
        }
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int adjNode : adjacentMap.get(currentNode)) {
                if (visitedSet.contains(adjNode)) {
                    continue;
                }

                queue.offer(adjNode);
            }

            visitedSet.add(currentNode);
        }
    }

    private static void dfs(int startNode) {
        visitedSet.add(startNode);

        for (int adjNode : adjacentMap.get(startNode)) {
            if (visitedSet.contains(adjNode)) {
                continue;
            }

            dfs(adjNode);
        }
    }
}
