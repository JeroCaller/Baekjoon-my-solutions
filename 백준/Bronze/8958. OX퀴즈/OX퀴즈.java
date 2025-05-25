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
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            String[] inputs = br.readLine().split("X");
            int total = 0;

            for (String token : inputs) {
                if (token.isBlank()) {
                    continue;
                }
                total += sum(token.length());
            }

            bw.write(String.valueOf(total));
            bw.newLine();
        }
    }

    public static int sum(int n) {
        return (n + 1) * n / 2;
    }

}