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
        String[] source = br.readLine().split(" ");
        int N = Integer.parseInt(source[0]);
        int M = Integer.parseInt(source[1]);
        int k = Integer.parseInt(source[2]);

        int q = k / M;
        int r = k % M;

        bw.write(q + " " + r);
    }

}
