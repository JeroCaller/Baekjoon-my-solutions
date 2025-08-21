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
        final int N = Integer.parseInt(br.readLine());
        int count = 0;

        outer: for (int i = 1; i <= N; ++i) {
            String numToStr = String.valueOf(i);

            if (numToStr.length() <= 2) {
                ++count;
                continue;
            }

            int diff = charToNum(numToStr.charAt(1)) - charToNum(numToStr.charAt(0));
            for (int j = 1; j < numToStr.length() - 1; ++j) {
                if (charToNum(numToStr.charAt(j + 1)) - charToNum(numToStr.charAt(j)) != diff) {
                    continue outer;
                }
            }
            ++count;
        }

        bw.write(String.valueOf(count));
    }

    private static int charToNum(char a) {
        return a - '0';
    }
}
