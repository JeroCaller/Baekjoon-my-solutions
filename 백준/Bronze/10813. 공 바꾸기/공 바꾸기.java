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
        int[] numbers = new int[N + 1];  // 0번째 자리는 사용하지 않음.

        for (int l = 1; l < numbers.length; ++l) {
            numbers[l] = l;
        }

        for (int i = 0; i < M; ++i) {
            String[] input = br.readLine().split(" ");
            int[] indexes = new int[2];
            for (int j = 0; j < indexes.length; ++j) {
                indexes[j] = Integer.parseInt(input[j]);
            }

            int temp = numbers[indexes[0]];
            numbers[indexes[0]] = numbers[indexes[1]];
            numbers[indexes[1]] = temp;
        }

        for (int k = 1; k < numbers.length; ++k) {
            bw.write(String.valueOf(numbers[k]) + " ");
        }
    }
}