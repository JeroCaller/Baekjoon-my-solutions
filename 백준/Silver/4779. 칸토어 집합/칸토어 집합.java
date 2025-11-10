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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String input;

        while (true) {
            input = br.readLine();

            if (input == null || input.isBlank()) {
                break;
            }

            int num = Integer.parseInt(input);
            int length = (int) Math.pow(3, num);
            StringBuilder stringBuilder = new StringBuilder(" ".repeat(length));
            Logic logic = new Logic(length);
            logic.execute();

            for (Interval interval : logic.getUnitIntervals()) {
                stringBuilder.replace(interval.getStartIdx(), interval.getEndIdx() + 1, "-");
            }

            bw.write(stringBuilder.toString());
            bw.newLine();
        }
    }
}

class Interval {
    private int startIdx;
    private int endIdx;

    public Interval(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public int getLength() {
        return endIdx - startIdx + 1;
    }
}

class Logic {
    private final List<Interval> unitIntervals = new ArrayList<>();
    private final Queue<Interval> intervalQueue = new ArrayDeque<>();

    public Logic(int n) {
        intervalQueue.offer(new Interval(0, n - 1));
    }

    public List<Interval> getUnitIntervals() {
        return unitIntervals;
    }

    public void execute() {
        while (!intervalQueue.isEmpty()) {
            Interval interval = intervalQueue.poll();

            if (interval.getLength() == 1) {
                unitIntervals.add(interval);
                continue;
            }

            int nextLength = interval.getLength() / 3;
            intervalQueue.offer(new Interval(
                interval.getStartIdx(),
                interval.getStartIdx() + nextLength - 1
            ));
            intervalQueue.offer(new Interval(
                interval.getEndIdx() - nextLength + 1,
                interval.getEndIdx()
            ));
        }
    }
}