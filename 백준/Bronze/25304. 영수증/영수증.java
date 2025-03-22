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

        int expected = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int actual = 0;

        String[] oneLine;
        for (int i = 1; i <= n; ++i) {
            oneLine = br.readLine().split(" ");
            actual += Integer.parseInt(oneLine[0]) * Integer.parseInt(oneLine[1]);
        }

        String result = (expected == actual) ? "Yes" : "No";
        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }

}
