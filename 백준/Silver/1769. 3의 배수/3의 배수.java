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
        String x = br.readLine();
        int count = 0;
        int y;

        if (x.length() != 1) {
            do {
                y = 0;

                for (int i = 0; i < x.length(); ++i) {
                    y += x.charAt(i) - '0';
                }

                x = String.valueOf(y);
                ++count;
            } while (y >= 10);
        } else {
            y = Integer.parseInt(x);
        }

        String result = "NO";
        if (y % 3 == 0) {
            result = "YES";
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(result);
    }
}
