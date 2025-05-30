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
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[8];

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String result = "mixed";
        for (int j = 0; j < numbers.length - 1; ++j) {
            if (numbers[j] + 1 == numbers[j + 1]) {
                result = "ascending";
            } else if (numbers[j] - 1 == numbers[j + 1]) {
                result = "descending";
            } else {
                result = "mixed";
                break;
            }
        }
        bw.write(result);
    }
}