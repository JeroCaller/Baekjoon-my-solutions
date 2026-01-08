import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

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
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int S = Integer.parseInt(conditions[1]);
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = countNumberOfCases(nums, S);
        bw.write(String.valueOf(answer));
    }

    public static int countNumberOfCases(int[] nums, int s) {
        int count = 0;
        Stack<Deque<Integer>> stack = new Stack<>();  // list of indices, not values

        for (int i = 0; i < nums.length; ++i) {
            Deque<Integer> indicesQueue = new ArrayDeque<>();
            indicesQueue.offer(i);
            stack.push(indicesQueue);
        }

        while (!stack.isEmpty()) {
            Deque<Integer> indicesQueue = stack.pop();
            int total = 0;

            for (int idx : indicesQueue) {
                total += nums[idx];
            }

            if (total == s) {
                ++count;
            }

            for (int i = indicesQueue.peekLast() + 1; i < nums.length; ++i) {
                Deque<Integer> nextIndicesQueue = new ArrayDeque<>();

                for (int idx : indicesQueue) {
                    nextIndicesQueue.offer(idx);
                }

                nextIndicesQueue.offer(i);
                stack.push(nextIndicesQueue);
            }
        }

        return count;
    }
}
