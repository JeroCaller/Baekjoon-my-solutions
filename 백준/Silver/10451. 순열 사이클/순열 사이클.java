import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = new int[n + 1];
            boolean[] isKeyVisited = new boolean[n + 1];
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int count = 0;

            for (int j = 1; j < numbers.length; ++j) {
                numbers[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int j = 1; j < numbers.length; ++j) {
                if (isKeyVisited[j]) {
                    continue;
                }

                int keyIdx = j;

                while (!isKeyVisited[keyIdx]) {
                    isKeyVisited[keyIdx] = true;
                    keyIdx = numbers[keyIdx];
                }

                ++count;
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }
}
