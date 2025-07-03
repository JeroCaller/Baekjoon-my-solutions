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
        final int C = Integer.parseInt(br.readLine());
        String encoded = br.readLine();
        final int R = encoded.length() / C;
        char[][] table = new char[R][C];

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (i % 2 == 0) {
                    table[i][j] = encoded.charAt(j + i * C);
                } else {
                    table[i][j] = encoded.charAt((C - 1 - j) + i * C);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < C; ++i) {
            for (int j = 0; j < R; ++j) {
                stringBuilder.append(table[j][i]);
            }
        }

        bw.write(stringBuilder.toString());
    }
}