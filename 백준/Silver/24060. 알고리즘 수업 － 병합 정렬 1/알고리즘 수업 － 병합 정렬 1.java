import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        final int K = Integer.parseInt(firstLine[1]);
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[N];

        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        MergeSort mergeSort = new MergeSort(K);
        mergeSort.sort(array);
        bw.write(String.valueOf(mergeSort.getTargetArrayElement()));
    }
}

class MergeSort {
    private int targetSaveCount;
    private int currentSaveCount;
    private int targetArrayElement = -1;

    public MergeSort(int targetSaveCount) {
        this.targetSaveCount = targetSaveCount;
        this.currentSaveCount = 1;
    }

    public int getTargetArrayElement() {
        return targetArrayElement;
    }

    public void sort(int[] array) {
        _sort(array, 0, array.length - 1);
    }

    private void _sort(int[] array, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }

        int midIdx = (leftIdx + rightIdx) / 2;
        _sort(array, leftIdx, midIdx);
        _sort(array, midIdx + 1, rightIdx);
        merge(array, leftIdx, midIdx, rightIdx);
    }

    private void merge(int[] array, int leftIdx, int midIdx, int rightIdx) {
        int leftArrayIdx = leftIdx;
        int rightArrayIdx = midIdx + 1;
        int[] tempArray = new int[rightIdx - leftIdx + 1];
        int tempIdx = 0;

        while (leftArrayIdx <= midIdx && rightArrayIdx <= rightIdx) {
            if (array[leftArrayIdx] <= array[rightArrayIdx]) {
                tempArray[tempIdx++] = array[leftArrayIdx++];
            } else {
                tempArray[tempIdx++] = array[rightArrayIdx++];
            }
        }

        while (leftArrayIdx <= midIdx) {
            tempArray[tempIdx++] = array[leftArrayIdx++];
        }

        while (rightArrayIdx <= rightIdx) {
            tempArray[tempIdx++] = array[rightArrayIdx++];
        }

        int arrayIdx = leftIdx;
        tempIdx = 0;

        while (tempIdx < tempArray.length) {
            array[arrayIdx] = tempArray[tempIdx++];

            if (currentSaveCount++ == targetSaveCount) {
                targetArrayElement = array[arrayIdx];
            }

            ++arrayIdx;
        }
    }
}