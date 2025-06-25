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
        final int T = Integer.parseInt(br.readLine());
        Set<Character> numSet = new HashSet<>();

        for (int i = 0; i < T; ++i) {
            String numberStr = br.readLine();
            for (int j = 0; j < numberStr.length(); ++j) {
                numSet.add(numberStr.charAt(j));
            }
            bw.write(String.valueOf(numSet.size()));
            bw.newLine();
            numSet.clear();
        }
    }
}