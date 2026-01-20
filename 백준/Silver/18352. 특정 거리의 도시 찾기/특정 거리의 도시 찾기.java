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

    private static int n, m, k, x;
    private static final Map<Integer, List<Integer>> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] conditions = br.readLine().split(" ");
        n = Integer.parseInt(conditions[0]);
        m = Integer.parseInt(conditions[1]);
        k = Integer.parseInt(conditions[2]);
        x = Integer.parseInt(conditions[3]);

        for (int i = 0; i < m; ++i) {
            String[] input = br.readLine().split(" ");
            int key = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            if (nodeMap.containsKey(key)) {
                nodeMap.get(key).add(value);
            } else {
                List<Integer> newValueList = new ArrayList<>();
                newValueList.add(value);
                nodeMap.put(key, newValueList);
            }
        }

        List<Integer> answers = search();

        if (answers.isEmpty()) {
            bw.write("-1");
            return;
        }

        for (int num : answers) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }
    }

    private static List<Integer> search() {
        List<Integer> answers = new ArrayList<>();
        Queue<CityNode> queue = new ArrayDeque<>();
        boolean[] hasVisited = new boolean[n + 1];
        queue.offer(new CityNode(x, 0));
        hasVisited[x] = true;

        while (!queue.isEmpty()) {
            CityNode currentCity = queue.poll();

            if (currentCity.getDepth() == k) {
                answers.add(currentCity.getCityNum());
                continue;
            }

            if (!nodeMap.containsKey(currentCity.getCityNum())) continue;

            for (int nextCity : nodeMap.get(currentCity.getCityNum())) {
                if (currentCity.getDepth() >= k) break;
                if (hasVisited[nextCity]) continue;
                queue.offer(new CityNode(nextCity, currentCity.getDepth() + 1));
                hasVisited[nextCity] = true;
            }
        }

        answers.sort((n1, n2) -> n1 - n2);
        return answers;
    }
}

class CityNode {
    private int cityNum;
    private int depth;

    public CityNode(int cityNum, int depth) {
        this.cityNum = cityNum;
        this.depth = depth;
    }

    public int getCityNum() { return cityNum; }
    public int getDepth() { return depth; }
}