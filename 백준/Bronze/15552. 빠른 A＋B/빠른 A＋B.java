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

        int t = Integer.parseInt(br.readLine());
        int a, b;
        String[] source;
        for (int i = 1; i <= t; ++i) {
            source = br.readLine().split(" ");
            a = Integer.parseInt(source[0]);
            b = Integer.parseInt(source[1]);
            bw.write(String.valueOf(a + b));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
