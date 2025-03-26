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
        int[] levels = new int[4];
        for (int i = 0; i < 4; ++i) {
            levels[i] = Integer.parseInt(source[i]);
        }

        int result =
            Math.abs((levels[3] + levels[0]) - (levels[2] + levels[1]));
        bw.write(String.valueOf(result));
    }

}
