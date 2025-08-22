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
        int minDiff = 51;
        int minDiffIdx = -1;

        if (inputs[0].length() == inputs[1].length()) {
            bw.write(String.valueOf(getDiffCount(inputs[0], inputs[1])));
            return;
        }

        for (int i = 0; i <= inputs[1].length() - inputs[0].length(); ++i) {
            int diffCount = 0;
            String subB = inputs[1].substring(i, i + inputs[0].length());
            diffCount = getDiffCount(inputs[0], subB);

            if (minDiff > diffCount) {
                minDiff = diffCount;
                minDiffIdx = i;
            }
        }

        bw.write(String.valueOf(minDiff));
    }

    private static int getDiffCount(String a, String b) {
        if (a.length() != b.length()) return -1;

        int diffCount = 0;

        for (int i = 0; i < b.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++diffCount;
            }
        }

        return diffCount;
    }
}
