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
        int firstNum = Integer.parseInt(br.readLine());

        String secondNumStr = br.readLine();
        String[] secondSplit = secondNumStr.split("");
        int secondNum = Integer.parseInt(secondNumStr);

        int[] results = new int[4];

        for (int i = 0; i < secondSplit.length; ++i) {
            results[i] = firstNum * Integer
                .parseInt(secondSplit[secondSplit.length - 1 - i]);
        }

        results[3] = firstNum * secondNum;

        for (int result : results) {
            bw.write(String.valueOf(result));
            bw.newLine();
        }

    }

}
