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
        String replaced = source.replace("XXXX", "AAAA")
            .replace("XX", "BB");
        if (replaced.contains("X")) {
            bw.write("-1");
        } else {
            bw.write(replaced);
        }
    }

}
