import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (j <= n - i) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            if (i != n) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
