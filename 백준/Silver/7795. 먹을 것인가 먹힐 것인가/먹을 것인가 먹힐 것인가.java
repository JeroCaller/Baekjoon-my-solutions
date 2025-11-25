import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        final int T = Integer.parseInt(br.readLine());
        final BinarySearch binarySearch = new BinarySearch();

        for (int i = 0 ; i < T; ++i) {
            String[] nm = br.readLine().split(" ");
            final int N = Integer.parseInt(nm[0]);
            final int M = Integer.parseInt(nm[1]);
            int[] arrayA = toIntArray(new StringTokenizer(br.readLine(), " "));
            int[] arrayB = toIntArray(new StringTokenizer(br.readLine(), " "));
            int count = 0;

            Arrays.sort(arrayA);
            Arrays.sort(arrayB);

            for (int currentNumber : arrayA) {
                int resultIdx = binarySearch.getIndexOf(arrayB, currentNumber);

                if (resultIdx == -1) {
                    continue;
                }

                if (arrayB[resultIdx] == currentNumber) {
                    count += resultIdx;
                } else {
                    count += resultIdx + 1;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }

    private static int[] toIntArray(StringTokenizer stringTokenizer) {
        int[] array = new int[stringTokenizer.countTokens()];

        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return array;
    }
}

class BinarySearch {
    private int currentIdx;

    public int getIndexOf(int[] array, int targetNumber) {
        currentIdx = -1;
        int resultIdx = _getIndexOf(array, targetNumber, 0, array.length - 1);

        if (resultIdx == -1) {
            if (array[currentIdx] > targetNumber) {
                return currentIdx - 1;
            }

            if (array[currentIdx] < targetNumber) {
                return currentIdx;
            }
        }

        while (resultIdx - 1 >= 0 && array[resultIdx] == array[resultIdx - 1]) {
            --resultIdx;
        }

        if (resultIdx == 0 && array[resultIdx] >= targetNumber) {
            return -1;
        }

        return resultIdx;
    }

    private int _getIndexOf(int[] array, int targetNumber, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return -1;
        }

        currentIdx = (leftIdx + rightIdx) / 2;

        if (array[currentIdx] > targetNumber) {
            return _getIndexOf(array, targetNumber, leftIdx, currentIdx - 1);
        } else if (array[currentIdx] < targetNumber) {
            return _getIndexOf(array, targetNumber, currentIdx + 1, rightIdx);
        } else {
            return currentIdx;
        }
    }
}