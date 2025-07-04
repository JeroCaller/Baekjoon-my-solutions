import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        final int N = 9;
        int[] heights = new int[N];
        int total = 0;

        for (int i = 0; i < N; ++i) {
            int number = Integer.parseInt(br.readLine());
            heights[i] = number;
            total += number;
        }

        outer: for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (total - heights[i] - heights[j] == 100) {
                    heights[i] = -1;
                    heights[j] = -1;
                    break outer;
                }
            }
        }

        Arrays.sort(heights);
        for (int i = 2; i < N; ++i) {
            bw.write(String.valueOf(heights[i]));
            bw.newLine();
        }
    }
}