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
        String[] source = br.readLine().split(" ");
        final int N = Integer.parseInt(source[0]);
        final int M = Integer.parseInt(source[1]);
        int[] results = new int[N + 1]; // zero index = garbage

        for (int i = 0; i < M; ++i) {
            int[] nums = getNumsInOneLine(br.readLine().split(" "));
            for (int j = nums[0]; j <= nums[1]; ++j) {
                results[j] = nums[2];
            }
        }

        for (int k = 1; k < results.length; ++k) {
            bw.write(results[k] + " ");
        }
    }

    public static int[] getNumsInOneLine(String[] oneLine) {
        int[] nums = new int[oneLine.length];
        for (int i = 0; i < oneLine.length; ++i) {
            nums[i] = Integer.parseInt(oneLine[i]);
        }
        return nums;
    }

}
