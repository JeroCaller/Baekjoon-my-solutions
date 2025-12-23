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
        final short N = Short.parseShort(br.readLine());
        short[] numbers = new short[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (short i = 0; i < N; ++i) {
            numbers[i] = Short.parseShort(stringTokenizer.nextToken());
        }

        // numbers[i]를 마지막 원소로 하는 가장 긴 증가 부분 수열의 길이
        short[] dp = new short[N];
        Arrays.fill(dp, (short) 1);  // 자기 자신만 포함된 부분 배열도 성립. 1로 초기화
        short maxLength = 1;

        for (short i = 0; i < N; ++i) {
            for (short j = 0; j < i; ++j) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = (short) Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = (short) Math.max(maxLength, dp[i]);
        }

        bw.write(String.valueOf(maxLength));
    }
}
