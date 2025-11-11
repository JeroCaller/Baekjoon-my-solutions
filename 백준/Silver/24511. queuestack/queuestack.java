import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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
        final Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer stForQueueStack = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stForInitNums = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            int numForQueueStack = Integer.parseInt(stForQueueStack.nextToken());
            int initNum = Integer.parseInt(stForInitNums.nextToken());

            if (numForQueueStack == 0) {
               deque.offer(initNum);
            }
        }

        final int M = Integer.parseInt(br.readLine());
        StringTokenizer stForInputNums = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; ++i) {
            deque.offerFirst(Integer.parseInt(stForInputNums.nextToken()));
            bw.write(deque.pollLast() + " ");
        }
    }
}
