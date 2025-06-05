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
        String[] input = br.readLine().split(" ");
        int total = 0;
        for (String token : input) {
            total += rev(Integer.parseInt(token));
        }
        bw.write(String.valueOf(rev(total)));
    }

    public static int rev(int x) {
        String[] numToStr = String.valueOf(x).split("");
        for (int i = 0; i < numToStr.length / 2; ++i) {
            int endIdx = numToStr.length - 1 - i;
            String temp = numToStr[i];
            numToStr[i] = numToStr[endIdx];
            numToStr[endIdx] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < numToStr.length; ++j) {
            stringBuilder.append(numToStr[j]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}