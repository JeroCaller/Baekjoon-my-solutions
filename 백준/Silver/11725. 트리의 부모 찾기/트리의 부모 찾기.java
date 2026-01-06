import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private static boolean[] isVisited;
    private static int[] parentOf;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];
        parentOf = new int[N + 1];

        for (int i = 0; i < N - 1; ++i) {
            String[] input = br.readLine().split(" ");
            int leftNum = Integer.parseInt(input[0]);
            int rightNum = Integer.parseInt(input[1]);
            insertKeyValueToMap(leftNum, rightNum);
            insertKeyValueToMap(rightNum, leftNum);
        }

        recordParentChild();

        for (int i = 2; i <= N; ++i) {
            bw.write(String.valueOf(parentOf[i]));
            bw.newLine();
        }
    }

    private static void insertKeyValueToMap(int key, int value) {
        if (adjMap.containsKey(key)) {
            adjMap.get(key).add(value);
        } else {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(value);
            adjMap.put(key, valueList);
        }
    }

    private static void recordParentChild() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        isVisited[1] = true;

        while (!stack.isEmpty()) {
            int currentNum = stack.pop();

            for (int child : adjMap.get(currentNum)) {
                if (isVisited[child]) {
                    continue;
                }

                parentOf[child] = currentNum;
                stack.push(child);
                isVisited[child] = true;
            }
        }
    }
}
