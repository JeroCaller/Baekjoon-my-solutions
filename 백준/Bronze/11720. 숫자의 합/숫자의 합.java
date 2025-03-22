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
        String[] source = br.readLine().split("");
        int total = 0;
        for (int i = 0; i < n; ++i) {
            total += Integer.parseInt(source[i]);
        }
        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }

}
