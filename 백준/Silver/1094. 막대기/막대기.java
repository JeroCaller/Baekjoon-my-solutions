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
        int x = Integer.parseInt(br.readLine());

        int currentSquare = 1;
        int answer = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                ++answer;
            }

            x = x / 2;
            currentSquare *= 2;
        }

        bw.write(String.valueOf(answer));
    }
}