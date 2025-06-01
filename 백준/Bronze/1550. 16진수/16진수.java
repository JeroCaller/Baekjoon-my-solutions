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
        String source = br.readLine();
        int result = 0;
        for (int i = 0; i < source.length(); ++i) {
            char c = source.charAt(i);
            int toDecimal = 0;
            if ('A' <= c && c <= 'F') {
                toDecimal += c - 'A' + 10;
            } else {
                toDecimal += 9 - ('9' - c);
            }
            result += (int) (Math.pow(16, source.length() - i - 1) * toDecimal);
        }
        bw.write(String.valueOf(result));
    }
}