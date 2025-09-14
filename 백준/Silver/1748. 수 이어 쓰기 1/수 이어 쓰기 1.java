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
        final String nStr = br.readLine();
        final int N = Integer.parseInt(nStr);
        final StringBuilder stringBuilder = new StringBuilder("1");
        int answer = 0;

        for (int i = 1; i < nStr.length(); ++i) {
            answer += (int) (i * (9 * Math.pow(10, i - 1)));
            stringBuilder.append("0");
        }

        answer += nStr.length() * (N - Integer.parseInt(stringBuilder.toString()) + 1);
        bw.write(String.valueOf(answer));
    }
}
