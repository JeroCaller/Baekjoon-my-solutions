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
        int n = Integer.parseInt(inputs[0]);
        int kimNum = Integer.parseInt(inputs[1]);
        int imNum = Integer.parseInt(inputs[2]);

        int count = 1;
        while (kimNum > 0 && imNum > 0) {
            int lowNum = Math.min(kimNum, imNum);
            int highNum = Math.max(kimNum, imNum);

            if (lowNum % 2 == 1 && lowNum + 1 == highNum) {
                break;
            }

            kimNum = (kimNum / 2) + (kimNum % 2);
            imNum = (imNum / 2) + (imNum % 2);
            ++count;
        }

        if (kimNum == 0 || imNum == 0) {
            count = -1;
        }

        bw.write(String.valueOf(count));
    }
}
