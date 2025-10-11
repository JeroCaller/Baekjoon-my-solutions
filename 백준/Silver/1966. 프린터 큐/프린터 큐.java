import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
        final int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> importanceQueue = null;

        for (int i = 0; i < T; ++i) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            while (stringTokenizer.hasMoreTokens()) {
                queue.offer(Integer.parseInt(stringTokenizer.nextToken()));
            }

            importanceQueue = queue.stream()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toCollection(ArrayDeque::new));

            int currentTargetPos = m;
            int count = 0;

            while (!queue.isEmpty() && currentTargetPos >= 0) {
                if (importanceQueue.peek().equals(queue.peek())) {
                    queue.poll();
                    importanceQueue.poll();
                    ++count;
                    --currentTargetPos;
                } else {
                    if (currentTargetPos == 0) {
                        currentTargetPos = queue.size() - 1;
                    } else {
                        --currentTargetPos;
                    }

                    queue.offer(queue.poll());
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();

            queue.clear();
            importanceQueue.clear();
        }
    }
}
