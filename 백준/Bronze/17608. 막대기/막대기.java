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
        int[] sticks = new int[N];
        for (int i = 0; i < N; ++i) {
            sticks[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(sticks[N - 1]);
        for (int i = N - 2; i >= 0; --i) {
            if (stack.peek() < sticks[i]) {
                stack.push(sticks[i]);
            }
        }
        bw.write(String.valueOf(stack.size()));
    }

}