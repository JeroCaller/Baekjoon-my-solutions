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
        int scenarioNum = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String[] names = new String[n];
            for (int i = 0; i < n; ++i) {
                names[i] = br.readLine();
            }

            int listSize = 2 * n - 1;
            int[] studentNumbers = new int[n];
            for (int i = 0; i < listSize; ++i) {
                int currentNumber = Integer.parseInt(br.readLine().split(" ")[0]);
                ++studentNumbers[currentNumber - 1];
            }

            int targetIdx = 0;
            for (int i = 0; i < studentNumbers.length; ++i) {
                if (studentNumbers[i] == 1) {
                    targetIdx = i;
                    break;
                }
            }

            bw.write((scenarioNum++) + " " + names[targetIdx]);
            bw.newLine();
        }
    }
}
