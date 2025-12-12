import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
        final int V = Integer.parseInt(firstLine[2]);
        final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

        for (int i = 0; i < M; ++i) {
            String[] oneLine = br.readLine().split(" ");
            int startNum = Integer.parseInt(oneLine[0]);
            int endNum = Integer.parseInt(oneLine[1]);

            putEntryToMap(adjacentMap, startNum, endNum);
            putEntryToMap(adjacentMap, endNum, startNum);
        }

        for (int key : adjacentMap.keySet()) {
            adjacentMap.get(key).sort(Comparator.naturalOrder());
        }

        List<Integer> dfsResult = dfs(adjacentMap, N, V);
        List<Integer> bfsResult = bfs(adjacentMap, N, V);

        for (int num : dfsResult) {
            bw.write(num + " ");
        }

        bw.newLine();

        for (int num : bfsResult) {
            bw.write(num + " ");
        }
    }

    private static void putEntryToMap(Map<Integer, List<Integer>> map, int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(value);
            map.put(key, oneList);
        }
    }

    private static List<Integer> dfs(Map<Integer, List<Integer>> map, int n, int start) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisisted = new boolean[n + 1];
        stack.add(start);

        while (!stack.isEmpty()) {
            int nextNum = stack.pop();

            if (!isVisisted[nextNum]) {
                result.add(nextNum);
                isVisisted[nextNum] = true;
            }

            if (!map.containsKey(nextNum) || map.get(nextNum).isEmpty()) {
                break;
            }

            List<Integer> oneList = map.get(nextNum);

            for (int i = oneList.size() - 1; i >= 0; --i) {
                if (isVisisted[oneList.get(i)]) {
                    continue;
                }

                stack.push(oneList.get(i));
            }
        }

        return result;
    }

    private static List<Integer> bfs(Map<Integer, List<Integer>> map, int n, int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n + 1];
        queue.offer(start);

        while (!queue.isEmpty()) {
            int nextNum = queue.poll();

            if (!isVisited[nextNum]) {
                result.add(nextNum);
                isVisited[nextNum] = true;
            }

            if (!map.containsKey(nextNum) || map.get(nextNum).isEmpty()) {
                break;
            }

            for (int value : map.get(nextNum)) {
                if (isVisited[value]) {
                    continue;
                }

                queue.offer(value);
            }
        }

        return result;
    }
}
