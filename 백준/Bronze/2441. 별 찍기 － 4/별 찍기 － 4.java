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
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            int stars = N - i;
            stringBuilder.append(" ".repeat(i))
                .append("*".repeat(stars))
                .append("\n");
        }

        bw.write(stringBuilder.toString());
    }

}
