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
        int N = Integer.parseInt(br.readLine());
        String[] source = br.readLine().split(" ");
        int[] nums = new int[N];

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(source[i]);
        }

        int[] sortedNums = Arrays.stream(nums).sorted()
            .toArray();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sortedNums[0]);
        stringBuilder.append(" ");
        stringBuilder.append(sortedNums[N-1]);

        bw.write(stringBuilder.toString());
    }

}
