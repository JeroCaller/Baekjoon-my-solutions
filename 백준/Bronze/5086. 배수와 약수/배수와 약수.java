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
            int[] numbers = new int[2];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < inputs.length; ++i) {
                numbers[i] = Integer.parseInt(inputs[i]);
            }
            if (numbers[0] == numbers[1] && numbers[0] == 0) {
                break;
            }

            String result = null;
            if (numbers[1] % numbers[0] == 0) {
                result = "factor";
            } else if (numbers[0] % numbers[1] == 0) {
                result = "multiple";
            } else {
                result = "neither";
            }
            bw.write(result);
            bw.newLine();

        }
    }

}
