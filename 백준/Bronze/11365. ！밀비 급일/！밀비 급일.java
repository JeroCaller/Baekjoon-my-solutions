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
        String[] alphabets;
        String source;
        while (true) {
            source = br.readLine();
            if (source.equals("END")) {
                break;
            }

            alphabets = source.split("");
            int n = alphabets.length;
            int right_idx;
            String temp;
            for (int i = 0; i < n / 2; ++i) {
                right_idx = n - 1 - i;
                temp = alphabets[i];
                alphabets[i] = alphabets[right_idx];
                alphabets[right_idx] = temp;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (String s : alphabets) {
                stringBuilder.append(s);
            }
            bw.write(stringBuilder.toString());
            bw.newLine();
        }
    }

}
