import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//@Slf4j
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
        final int T = Integer.parseInt(firstLine[1]);
        final BinarySearch binarySearch = new BinarySearch();

        int answer = -1;
        String[] nextLine;
        int S, I, C;

        outer: for (int i = 0; i < N; ++i) {
            nextLine = br.readLine().split(" ");
            S = Integer.parseInt(nextLine[0]);
            I = Integer.parseInt(nextLine[1]);
            C = Integer.parseInt(nextLine[2]);

            if (T == S) {
                answer = 0;
                break;
            }

            if (T > S + I * C) {
                continue;
            }

            binarySearch.setN(C);
            int nextNumber = binarySearch.getNumber();
            int beforeNumber = -1;
            int waitTime = 0;

            while (nextNumber != -1) {
                //log.info("currentNumber: {}", nextNumber);

                if (nextNumber == beforeNumber) {
                    break;
                }

                waitTime = (S + nextNumber * I) - T;
                beforeNumber = nextNumber;

                if (waitTime < 0) {
                    nextNumber = binarySearch.getNumber(BinarySearch.Direction.UP);
                    continue;
                } else if (waitTime > 0) {
                    nextNumber = binarySearch.getNumber(BinarySearch.Direction.DOWN);
                } else {
                    answer = waitTime;
                    break outer;
                }

                if (answer == -1 || answer > waitTime) {
                    answer = waitTime;
                    //log.info("answer is changed: {}", answer);
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}

//@Getter
//@Slf4j
class BinarySearch {

    private int n;
    private int leftPointer;
    private int midPointer;
    private int rightPointer;

    enum Direction {
        UP,
        DOWN
    }

    public void setN(int n) {
        this.n = n;
        leftPointer = 0;
        rightPointer = n;
    }

    public int getNumber() {
        midPointer = (leftPointer + rightPointer) / 2;
        return midPointer;
    }

    public int getNumber(Direction direction) {
        switch (direction) {
            case UP:
                leftPointer = midPointer;
                break;
            case DOWN:
                rightPointer = midPointer;
                break;
        }

        //log.info("left: {}, right: {}", leftPointer, rightPointer);

        if (leftPointer >= rightPointer) {
            return -1;
        }

        midPointer = (leftPointer + rightPointer) / 2;
        return midPointer;
    }
}