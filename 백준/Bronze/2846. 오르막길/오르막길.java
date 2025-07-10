import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        final int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            heights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(heights[0]);
        for (int i = 1; i < N; ++i) {
            if (heights[i] > stack.peek()) {
                stack.push(heights[i]);
                continue;
            }

            if (stack.size() <= 1) {
                stack.clear();
                stack.push(heights[i]);
                continue;
            }

            answer = getMaxNum(stack, answer);
            stack.clear();
            stack.push(heights[i]);
        }

        if (stack.size() > 1) {
            answer = getMaxNum(stack, answer);
        }

        bw.write(String.valueOf(answer));
    }

    public static int getMaxNum(Stack<Integer> stack, int answer) {
        int diff = stack.peek() - stack.get(0);
        return Math.max(diff, answer);
    }
}