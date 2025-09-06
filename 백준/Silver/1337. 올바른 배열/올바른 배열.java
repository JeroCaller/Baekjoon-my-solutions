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

        Arrays.sort(numbers);

        int maxIndexRange = 1;
        int start = 0;
        int end = 1;

        while (start < N && end < N) {
            int indexDiff = end - start + 1;

            if (numbers[end] - numbers[start] < 5) {
                if (maxIndexRange < indexDiff) {
                    maxIndexRange = indexDiff;
                }

                ++end;
            } else {
                ++start;
                end = start + 1;
            }
        }

        bw.write(String.valueOf(5 - maxIndexRange));
    }
}
