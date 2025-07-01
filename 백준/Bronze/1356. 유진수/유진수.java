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
        String numberStr = br.readLine();
        if (numberStr.length() == 1) {
            bw.write("NO");
            return;
        }

        for (int mid = 0; mid < numberStr.length(); ++mid) {
            int leftTotal = 1;
            int rightTotal = 1;

            for (int i = 0; i <= mid; ++i) {
                leftTotal *= numberStr.charAt(i) - '0';
            }

            for (int j = mid + 1; j < numberStr.length(); ++j) {
                rightTotal *= numberStr.charAt(j) - '0';
            }

            if (leftTotal == rightTotal) {
                bw.write("YES");
                return;
            }
        }

        bw.write("NO");
    }
}