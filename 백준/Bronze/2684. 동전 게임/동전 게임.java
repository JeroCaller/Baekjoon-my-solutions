import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        final int P = Integer.parseInt(br.readLine());
        int[] seriesCounter = new int[8];

        for (int i = 0; i < P; ++i) {
            String source = br.readLine();

            for (int j = 0; j + 3 <= source.length(); ++j) {
                String series = source.substring(j, j + 3)
                    .replace("H", "1")
                    .replace("T", "0");
                int counterIndex = Integer.parseInt(series, 2);
                ++seriesCounter[counterIndex];
            }

            for (int k : seriesCounter) {
                bw.write(k + " ");
            }
            bw.newLine();

            Arrays.fill(seriesCounter, 0);
        }
    }
}