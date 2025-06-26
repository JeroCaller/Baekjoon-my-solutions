import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];

        for (int i = 0; stringTokenizer.hasMoreTokens(); ++i) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        bw.write(String.valueOf(numbers[0] * numbers[N - 1]));
    }
}