import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
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
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        final Stack<Integer> standByStack = new Stack<>();
        final Queue<Integer> queue = new ArrayDeque<>();
        int lastPassedNum = 0;
        String answer = "Nice";

        while (stringTokenizer.hasMoreTokens()) {
            queue.offer(Integer.parseInt(stringTokenizer.nextToken()));
        }

        while (!queue.isEmpty()) {
            if (queue.peek().equals(lastPassedNum + 1)) {
                lastPassedNum = queue.poll();
            } else if (!standByStack.isEmpty() && standByStack.peek().equals(lastPassedNum + 1)) {
                lastPassedNum = standByStack.pop();
            } else {
                standByStack.push(queue.poll());
            }
        }

        while (!standByStack.isEmpty()) {
            if (standByStack.peek().equals(lastPassedNum + 1)) {
                lastPassedNum = standByStack.pop();
            } else {
                answer = "Sad";
                break;
            }
        }

        bw.write(answer);
    }
}
