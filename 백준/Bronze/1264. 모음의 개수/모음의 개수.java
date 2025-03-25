import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

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
        List<String> target = Arrays.asList("a", "e", "i", "o", "u");
        String[] source;

        while(true) {
            int total = 0;
            source = br.readLine().toLowerCase().split("");
            if (source[0].equals("#")) {
                break;
            }
            for (String s : source) {
                if (target.contains(s)) {
                    ++total;
                }
            }
            bw.write(String.valueOf(total));
            bw.newLine();
        }
    }

}
