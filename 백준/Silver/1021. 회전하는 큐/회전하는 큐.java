import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        final List<Integer> numbersList = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        while (stringTokenizer.hasMoreTokens()) {
            numbersList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        RotatingQueue rotatingQueue = new RotatingQueue(N, numbersList);
        rotatingQueue.execute();

        bw.write(String.valueOf(rotatingQueue.getRotateCounter()));
    }
}

//@Slf4j
class RotatingQueue {

    private final Deque<Integer> deque = new LinkedList<>();
    private List<Integer> targetPositions;
    private int rotateCounter = 0;

    public RotatingQueue(int size, List<Integer> targetPositions) {
        this.targetPositions = targetPositions;

        for (int i = 1; i <= size; ++i) {
            deque.offer(i);
        }

        //log.info("initial deque: {}", deque.toString());
    }

    public int getRotateCounter() {
        return rotateCounter;
    }

    public void execute() {
        while (!targetPositions.isEmpty()) {
            if (targetPositions.get(0).equals(deque.peek())) {
                //log.info("found target, the number {} was removed from deque", targetPositions.get(0));

                deque.poll();
                targetPositions.remove(0);

                //log.info("deque: {}", deque.toString());

                continue;
            }

            if (findIndex(targetPositions.get(0)) <= deque.size() / 2) {
                moveLeft();
            } else {
                moveRight();
            }

            //log.info("deque: {}", deque.toString());
        }
    }

    private int findIndex(int targetNumber) {
        int targetIndex = 0;
        boolean found = false;

        for (int number : deque) {
            if (targetNumber == number) {
                found = true;
                break;
            }

            ++targetIndex;
        }

        if (!found) {
            return -1;
        }

        return targetIndex;
    }

    private void moveLeft() {
        deque.offer(deque.poll());
        ++rotateCounter;
    }

    private void moveRight() {
        deque.offerFirst(deque.pollLast());
        ++rotateCounter;
    }
}