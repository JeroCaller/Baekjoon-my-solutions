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
        int[][] numbers = new int[9][9];

        for (int i = 0; i < 9; ++i) {
            String[] oneLineInput = br.readLine().split(" ");
            for (int j = 0; j < oneLineInput.length; ++j) {
                numbers[i][j] = Integer.parseInt(oneLineInput[j]);
            }
        }

        int x = 0;
        int y = 0;
        int maxNum = numbers[0][0];

        for (int k = 0; k < numbers.length; ++k) {
            for (int l = 0; l < numbers[k].length; ++l) {
                if (maxNum < numbers[k][l]) {
                    maxNum = numbers[k][l];
                    x = k;
                    y = l;
                }
            }
        }
        ++x;
        ++y;

        bw.write(String.valueOf(maxNum));
        bw.newLine();
        bw.write(x + " " + y);
    }

}
