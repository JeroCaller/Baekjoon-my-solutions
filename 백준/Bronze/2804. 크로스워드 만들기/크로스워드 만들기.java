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

        // row, column
        int[] positions = new int[2];

        outer: for (int i = 0; i < inputs[0].length(); ++i) {
            for (int j = 0; j < inputs[1].length(); ++j) {
                if (inputs[0].charAt(i) == inputs[1].charAt(j)) {
                    positions[0] = j;
                    positions[1] = i;
                    break outer;
                }
            }
        }

        for (int r = 0; r < inputs[1].length(); ++r) {
            for (int c = 0; c < inputs[0].length(); ++c) {
                char output;
                if (r == positions[0]) {
                    output = inputs[0].charAt(c);
                } else if (c == positions[1]) {
                    output = inputs[1].charAt(r);
                } else {
                    output = '.';
                }

                bw.write(output);
            }

            bw.newLine();
        }
    }
}