import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

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
        BigInteger[] numbers = new BigInteger[3];

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = new BigInteger(input[i]);
        }

        if (numbers[2].compareTo(numbers[1]) <= 0) {
            bw.write(String.valueOf(-1));
            return;
        }

        BigInteger criteria =
            numbers[0].divide(numbers[2].subtract(numbers[1]));
        bw.write(criteria.add(BigInteger.ONE).toString());
    }
}