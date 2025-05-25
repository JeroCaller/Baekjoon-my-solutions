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
        int total = 1;
        for (int i = 0; i < 3; ++i) {
            total *= Integer.parseInt(br.readLine());
        }

        int[] counter = new int[10];
        String[] tokens = String.valueOf(total).split("");
        for (String token : tokens) {
            int oneNumber = Integer.parseInt(token);
            ++counter[oneNumber];
        }

        for (int count : counter) {
            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }

}