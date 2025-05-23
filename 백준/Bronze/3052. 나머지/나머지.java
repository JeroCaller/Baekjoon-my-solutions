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
        final int N = 10;
        final int DIVIDER = 42;
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < N; ++i) {
            int number = Integer.parseInt(br.readLine());
            numSet.add(number % DIVIDER);
        }
        bw.write(String.valueOf(numSet.size()));
    }

}