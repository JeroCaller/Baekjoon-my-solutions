import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

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
        final String INPUT = br.readLine();
        final Set<String> SET = new HashSet<>();

        for (int i = 0; i < INPUT.length(); ++i) {
            for (int j = 0; j + i < INPUT.length(); ++j) {
                SET.add(INPUT.substring(j, j + i + 1));
            }
        }

        bw.write(String.valueOf(SET.size()));
    }
}
