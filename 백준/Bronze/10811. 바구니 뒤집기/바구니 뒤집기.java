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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        int[] numbers = new int[N + 1];  // won't use element at index 0

        for (int i = 1; i < numbers.length; ++i) {
            numbers[i] = i;
        }

        for (int j = 0; j < M; ++j) {
            String[] input = br.readLine().split(" ");
            int[] ij = new int[2];
            for (int k = 0; k < ij.length; ++k) {
                ij[k] = Integer.parseInt(input[k]);
            }

            for (int l = ij[0]; l <= (ij[0] + ij[1]) / 2; ++l) {
                int endIdx = ij[0] + ij[1] - l;

                int temp = numbers[l];
                numbers[l] = numbers[endIdx];
                numbers[endIdx] = temp;
            }
        }

        for (int x = 1; x < numbers.length; ++x) {
            bw.write(String.valueOf(numbers[x]) + " ");
        }
    }
}