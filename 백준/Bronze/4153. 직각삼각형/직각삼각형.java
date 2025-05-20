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
        while (true) {
            String inputOneLine = br.readLine();
            if (inputOneLine == null) {
                break;
            }

            String[] inputSplit = inputOneLine.split(" ");
            if (inputSplit[0].equals("0")) {
                break;
            }
            int[] numbers = new int[inputSplit.length];

            for (int i = 0; i < inputSplit.length; ++i) {
                numbers[i] = Integer.parseInt(inputSplit[i]);
            }
            numbers = getSortedIntArray(numbers);

            if (getIntSquared(numbers[0]) + getIntSquared(numbers[1]) == getIntSquared(numbers[2])) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.newLine();
        }

    }

    public static int[] getSortedIntArray(int[] numbers) {
        int endIndex = numbers.length - 1;
        for (int j = 0; j < numbers.length; ++j) {
            for (int k = 0; k < endIndex; ++k) {
                if (numbers[k] > numbers[k+1]) {
                    int tempValue = numbers[k];
                    numbers[k] = numbers[k+1];
                    numbers[k+1] = tempValue;
                }
            }
            --endIndex;
        }
        return numbers;
    }

    public static int getIntSquared(int number) {
        return number * number;
    }

}
