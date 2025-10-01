import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        final int N = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        final Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < C; ++i) {
            String[] inputs = br.readLine().split(" ");
            int key = Integer.parseInt(inputs[0]);
            int value = Integer.parseInt(inputs[1]);

            putDataInMap(map, key, value);
            putDataInMap(map, value, key);
        }

        int answer = 0;
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int currentKey = stack.pop();

            if (!map.containsKey(currentKey)) {
                continue;
            }

            for (int value : map.get(currentKey)) {
                if (!visited[value]) {
                    stack.push(value);
                    visited[value] = true;
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }

    private static void putDataInMap(Map<Integer, List<Integer>> map, int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            map.put(key, new LinkedList<>(List.of(value)));
        }
    }
}
