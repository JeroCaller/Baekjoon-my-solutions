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
        final int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int firstDescIdx = -1;

        for (int i = N - 1; i > 0; --i) {
            if (numbers[i - 1] > numbers[i]) {
                firstDescIdx = i - 1;
                break;
            }
        }

        if (firstDescIdx == -1) {
            bw.write("-1");
            return;
        }

        int targetIdx = 0;
        int targetNum = 0;

        for (int i = firstDescIdx + 1; i < N; ++i) {
            if (numbers[firstDescIdx] > numbers[i] && numbers[i] > targetNum) {
                targetIdx = i;
                targetNum = numbers[i];
            }
        }

        swap(numbers, firstDescIdx, targetIdx);

        int startIdx = firstDescIdx + 1;
        int endIdx = N - 1;

        while (startIdx < endIdx) {
            swap(numbers, startIdx, endIdx);
            ++startIdx;
            --endIdx;
        }

        for (int i = 0; i < N; ++i) {
            bw.write(numbers[i] + " ");
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
