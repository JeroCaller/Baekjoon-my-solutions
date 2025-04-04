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
        int[] times = new int[2];
        int[] results = new int[2];

        for (int i = 0; i < 2; ++i) {
            times[i] = Integer.parseInt(input[i]);
        }

        int minuteDiff = times[1] - 45;
        if (minuteDiff < 0) {
            results[0] = (times[0] == 0) ? 23 : times[0] - 1;
            results[1] = 60 + minuteDiff;
        } else {
            results[0] = times[0];
            results[1] = minuteDiff;
        }

        for (int result : results) {
            bw.write(result + " ");
        }

    }

}
