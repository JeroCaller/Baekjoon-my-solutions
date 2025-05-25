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
        int[] numbers = new int[2];

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = getReversedNumber(inputs[i]);
        }

        int result = Math.max(numbers[0], numbers[1]);
        bw.write(String.valueOf(result));
    }

    public static int getReversedNumber(String original) {
        String[] reversed = original.split("");
        for (int i = 0; i < reversed.length / 2; ++i) {
            String temp = reversed[i];
            reversed[i] = reversed[reversed.length - 1 - i];
            reversed[reversed.length - 1 - i] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String token : reversed) {
            stringBuilder.append(token);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}