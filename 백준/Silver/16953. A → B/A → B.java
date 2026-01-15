import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Map<Long, Long> pathMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        bfs(a, b);
        List<Long> path = constructPath(a, b);

        if (path == null) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(path.size()));
        }
    }

    private static void bfs(int a, int b) {
        Queue<Long> queue = new ArrayDeque<>();
        List<Action> actionList = new ArrayList<>();
        actionList.add(num -> num * 2);
        actionList.add(num -> Long.parseLong(String.format("%d1", num)));
        queue.offer((long) a);

        while (!queue.isEmpty()) {
            long currentNum = queue.poll();

            for (Action action : actionList) {
                long nextNum = action.action(currentNum);
                if (nextNum > b) continue;
                pathMap.put(nextNum, currentNum);
                if (nextNum == b) return;
                queue.offer(nextNum);
            }
        }
    }

    private static List<Long> constructPath(int startNum, int endNum) {
        List<Long> path = new ArrayList<>();
        long node = endNum;

        while (node != startNum) {
            path.add(node);

            try {
                node = pathMap.get(node);
            } catch (NullPointerException npe) {
                return null;
            }
        }

        path.add((long) startNum);
        return path;
    }
}

interface Action {
    long action(long num);
}
