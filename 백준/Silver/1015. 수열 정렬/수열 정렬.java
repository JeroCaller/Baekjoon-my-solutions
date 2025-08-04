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
        final int N = Integer.parseInt(br.readLine());
        Pair[] arrayA = new Pair[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            Pair pair = new Pair(number, i);
            arrayA[i] = pair;
        }

        Arrays.sort(arrayA, (pairOne, pairTwo) -> {
            int numDiff = pairOne.getElement() - pairTwo.getElement();

            if (numDiff == 0) {
                return pairOne.getOriginalIndex() - pairTwo.getOriginalIndex();
            }

            return numDiff;
        });

        int[] arrayP = new int[N];

        for (int i = 0; i < N; ++i) {
            arrayP[arrayA[i].getOriginalIndex()] = i;
        }

        for (int i = 0; i < N; ++i) {
            bw.write(arrayP[i] + " ");
        }
    }
}

class Pair {
    private int element;
    private int originalIndex;

    public Pair(int element, int originalIndex) {
        this.element = element;
        this.originalIndex = originalIndex;
    }

    public int getElement() {
        return element;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    @Override
    public String toString() {
        return String.format("(element: %d, original index: %d)", element, originalIndex);
    }
}