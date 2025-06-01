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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int K = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < secondLine.length; ++i) {
            numbers[i] = Integer.parseInt(secondLine[i]);
        }

        QuickSort quickSort = new QuickSort(numbers);
        numbers = quickSort.getSortedNumbers();
        bw.write(String.valueOf(numbers[numbers.length - K]));
    }
}

class QuickSort {
    private int[] numbers;

    QuickSort(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int[] getSortedNumbers() {
        recursiveSort(0, numbers.length - 1);
        return numbers;
    }

    private void recursiveSort(int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) return;

        int pivotIdx = (lowIdx + highIdx) / 2;
        pivotIdx = doPartitionAndGetFinalPivotIdx(lowIdx, highIdx, pivotIdx);
        recursiveSort(lowIdx, pivotIdx - 1);
        recursiveSort(pivotIdx + 1, highIdx);
    }

    private int doPartitionAndGetFinalPivotIdx(
        int lowIdx,
        int highIdx,
        int pivotIdx
    ) {
        // put the element at pivot index into the rightest
        // for computational convenience
        swap(pivotIdx, highIdx);
        pivotIdx = highIdx;

        int curIdx = 0;
        while (curIdx < pivotIdx) {
            if (numbers[curIdx] > numbers[pivotIdx]) {
                swap(curIdx, pivotIdx - 1);
                swap(pivotIdx - 1, pivotIdx);
                --pivotIdx;
            } else {
                ++curIdx;
            }
        }
        return pivotIdx;
    }

    private void swap(int leftIdx, int rightIdx) {
        int temp = numbers[leftIdx];
        numbers[leftIdx] = numbers[rightIdx];
        numbers[rightIdx] = temp;
    }
}