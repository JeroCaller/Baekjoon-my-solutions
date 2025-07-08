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
        int[][] apart = new int[15][15];
        apart[0][0] = -1;
        for (int i = 1; i < apart[0].length; ++i) {
            apart[0][i] = i;
        }

        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (apart[k][n] != 0) {
                bw.write(String.valueOf(apart[k][n]));
                bw.newLine();
                continue;
            }

            int answer = getNumOfResidents(apart, k, n);
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
    }

    public static int getNumOfResidents(int[][] apart, int k, int n) {
        if (apart[k - 1][n] == 0) {
            getNumOfResidents(apart, k - 1, n);
        }

        if (n >= 2) {
            if (apart[k][n - 1] == 0) {
                getNumOfResidents(apart, k, n - 1);
            }
        } else {
            apart[k][0] = -1;
            apart[k][1] = 1;
            return apart[k][1];
        }

        apart[k][n] = apart[k][n - 1] + apart[k - 1][n];
        return apart[k][n];
    }
}