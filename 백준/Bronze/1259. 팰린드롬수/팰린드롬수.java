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
        outer: while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            int halfIdx = (input.length() / 2) + (input.length() % 2);
            for (int i = 0; i < halfIdx; ++i) {
                int rightIdx = input.length() - 1 - i;
                if (input.charAt(i) != input.charAt(rightIdx)) {
                    bw.write("no");
                    bw.newLine();
                    continue outer;
                }
            }
            bw.write("yes");
            bw.newLine();
        }
    }
}