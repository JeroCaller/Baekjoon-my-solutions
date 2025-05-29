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
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= N; ++i) {
            String numToStr = String.valueOf(i);
            int divideSum = i;
            for (String oneNumber : numToStr.split("")) {
                divideSum += Integer.parseInt(oneNumber);
            }
            if (divideSum == N) {
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));
    }
}