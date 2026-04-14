import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, m;
    private static final List<Operator> operators = new ArrayList<>();
    private static final int LIMIT = 100000;
    private static final boolean[] visited = new boolean[LIMIT + 1];

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        operators.add(value -> value * 2);
        operators.add(value -> value - 1);
        operators.add(value -> value + 1);

        int answer = search();

        bw.write(String.valueOf(answer));
    }

    private static int search() {
        Queue<QueueElement> queue = new ArrayDeque<>();
        queue.offer(new QueueElement(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            QueueElement element = queue.poll();

            if (element.getX() == m) {
                return element.getDepth();
            }

            for (Operator operator : operators) {
                int actionResult = operator.action(element.getX());

                if (actionResult > LIMIT || actionResult < 0 || visited[actionResult]) {
                    continue;
                }

                if (actionResult == m) {
                    return element.getDepth() + 1;
                }

                queue.offer(new QueueElement(
                    actionResult,
                    element.getDepth() + 1
                ));
                visited[actionResult] = true;
            }
        }

        return -1;
    }
}

class QueueElement {
    private int x;
    private int depth;

    public QueueElement(int x, int depth) {
        this.x = x;
        this.depth = depth;
    }

    public int getX() { return x; }
    public int getDepth() { return depth; }
}

@FunctionalInterface
interface Operator {
    int action(int value);
}