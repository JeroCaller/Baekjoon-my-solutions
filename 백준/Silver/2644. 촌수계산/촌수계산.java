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

    private static final Map<Integer, List<Integer>> graphMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        String[] people = br.readLine().split(" ");
        int[] targetNums = new int[2];
        final int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < targetNums.length; ++i) {
            targetNums[i] = Integer.parseInt(people[i]);
        }

        for (int i = 0; i < M; ++i) {
            people = br.readLine().split(" ");
            int[] nums = {Integer.parseInt(people[0]), Integer.parseInt(people[1])};
            insertIntoMap(nums[0], nums[1]);
            insertIntoMap(nums[1], nums[0]);
        }

        bw.write(String.valueOf(search(targetNums[0], targetNums[1], N)));
    }

    private static void insertIntoMap(int key, int value) {
        if (graphMap.containsKey(key)) {
            graphMap.get(key).add(value);
        } else {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(value);
            graphMap.put(key, valueList);
        }
    }

    private static int search(int start, int end, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nextNode : graphMap.get(node)) {
                if (distances[nextNode] != -1) continue;
                distances[nextNode] = distances[node] + 1;
                if (nextNode == end) break;
                queue.offer(nextNode);
            }
        }

        return distances[end];
    }
}
