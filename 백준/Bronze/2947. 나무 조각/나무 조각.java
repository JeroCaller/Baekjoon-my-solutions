import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        String[] inputs = br.readLine().split(" ");
        final int N = inputs.length;
        int[] numbers = new int[N];

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N - 1; ++j) {
                if (numbers[j] <= numbers[j + 1]) {
                    continue;
                }

                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;

                for (int k = 0; k < N; ++k) {
                    bw.write(numbers[k] + " ");
                }
                bw.newLine();
            }

            boolean isSorted = true;
            for (int k = 0; k < N; ++k) {
                if (numbers[k] != k + 1) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}