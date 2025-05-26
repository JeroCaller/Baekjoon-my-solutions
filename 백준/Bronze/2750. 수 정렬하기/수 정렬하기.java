import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        int[] numbers = new int[N];

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        MergeSort mergeSort = new MergeSort(numbers);
        int[] result = mergeSort.getSortedNumber();
        for (int number: result) {
            bw.write(String.valueOf(number));
            bw.newLine();
        }
    }
}

class MergeSort {
    private int[] numbers;

    public MergeSort(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int[] getSortedNumber() {
        sort(0, numbers.length - 1);
        return numbers;
    }

    private void sort(int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {
            return;
        }
        int midIdx = (lowIdx + highIdx) / 2;
        sort(lowIdx, midIdx);
        sort(midIdx + 1, highIdx);
        merge(lowIdx, midIdx, highIdx);
    }

    private void merge(int lowIdx, int midIdx, int highIdx) {
        int[] leftSubArray = Arrays.copyOfRange(numbers, lowIdx, midIdx + 1);
        int[] rightSubArray = Arrays.copyOfRange(numbers, midIdx + 1, highIdx + 1);
        int leftArrayIdx = 0;
        int rightArrayIdx = 0;
        for (int i = lowIdx; i <= highIdx; ++i) {
            if (rightArrayIdx >= rightSubArray.length) {
                numbers[i] = leftSubArray[leftArrayIdx];
                ++leftArrayIdx;
            } else if (leftArrayIdx >= leftSubArray.length) {
                numbers[i] = rightSubArray[rightArrayIdx];
                ++rightArrayIdx;
            } else if (leftSubArray[leftArrayIdx] < rightSubArray[rightArrayIdx]) {
                numbers[i] = leftSubArray[leftArrayIdx];
                ++leftArrayIdx;
            } else if (leftSubArray[leftArrayIdx] >= rightSubArray[rightArrayIdx]) {
                numbers[i] = rightSubArray[rightArrayIdx];
                ++rightArrayIdx;
            }
        }
    }
}