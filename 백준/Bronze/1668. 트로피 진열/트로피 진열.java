import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        int[] heights = new int[N];
        for (int i = 0; i < N; ++i) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        leftStack.add(heights[0]);
        rightStack.add(heights[N - 1]);

        int leftIdx, rightIdx;
        for (int i = 1; i < N; ++i) {
            leftIdx = i;
            rightIdx = (N - 1) - i;
            if (leftStack.peek() < heights[leftIdx]) {
                leftStack.push(heights[leftIdx]);
            }
            if (rightStack.peek() < heights[rightIdx]) {
                rightStack.push(heights[rightIdx]);
            }
        }

        bw.write(String.valueOf(leftStack.size()));
        bw.newLine();
        bw.write(String.valueOf(rightStack.size()));
    }
}