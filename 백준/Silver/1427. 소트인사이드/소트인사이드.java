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
        String source = br.readLine();
        MergeSort mergeSort = new MergeSort(source.toCharArray());
        bw.write(mergeSort.getSortedString());
    }
}

class MergeSort {

    private char[] charArray;

    public MergeSort(char[] charArray) {
        this.charArray = charArray;
    }

    public String getSortedString() {
        recursiveSort(0, charArray.length - 1);
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : charArray) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void recursiveSort(int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {
            return;
        }

        int midIdx = (lowIdx + highIdx) / 2;
        recursiveSort(lowIdx, midIdx);
        recursiveSort(midIdx + 1, highIdx);
        merge(lowIdx, midIdx, highIdx);
    }

    private void merge(int lowIdx, int midIdx, int highIdx) {
        char[] leftSubArray = Arrays.copyOfRange(charArray, lowIdx, midIdx + 1);
        char[] rightSubArray = Arrays.copyOfRange(charArray, midIdx + 1, highIdx + 1);
        int leftSubArrayPointer = 0;
        int rightSubArrayPointer = 0;

        for (int i = lowIdx; i <= highIdx; ++i) {
            if (leftSubArrayPointer >= leftSubArray.length) {
                charArray[i] = rightSubArray[rightSubArrayPointer];
                ++rightSubArrayPointer;
            } else if (rightSubArrayPointer >= rightSubArray.length) {
                charArray[i] = leftSubArray[leftSubArrayPointer];
                ++leftSubArrayPointer;
            } else if (leftSubArray[leftSubArrayPointer] >= rightSubArray[rightSubArrayPointer]) {
                charArray[i] = leftSubArray[leftSubArrayPointer];
                ++leftSubArrayPointer;
            } else {
                charArray[i] = rightSubArray[rightSubArrayPointer];
                ++rightSubArrayPointer;
            }
        }
    }
}
