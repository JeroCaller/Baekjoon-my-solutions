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
        // space, number, large, small
        final int[] answers = {0, 0, 0, 0};
        final int SPACE = 32; // ascii code

        while (true) {
            clear(answers);
            String source = br.readLine();
            if (source == null || source.isBlank()) {
                break;
            }
            for (int i = 0; i < source.length(); ++i) {
                char oneChar = source.charAt(i);
                int idx = oneChar % SPACE == 0 ? 0 : oneChar / SPACE;
                answers[idx] += 1;
            }
            for (int j = 0; j < answers.length; ++j) {
                bw.write(String.valueOf(answers[answers.length - 1 - j]) + " ");
            }
            bw.newLine();
        }
    }

    public static void clear(int[] array) {
        Arrays.fill(array, 0);
    }
}