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

    /**
     * 연속된 자연수들의 합은 첫 항부터 끝 항까지 공차가 1인 등차수열의 합과도 같은 의미이다.
     * 등차수열 a(n) = a(1) + (n - 1) * d (n >= 1)에 대해, 등차수열의 합 N은
     * N = a(1) + a(2) + ... + a(n - 1) + a(n) = n * (a(1) + a(n)) / 2
     * = a(1) * n + n * (n - 1) / 2 (d = 1)
     * 이 때 우항의 두 번째 항 n * (n - 1) / 2는 1부터 n - 1까지의 합과도 동일하다.
     * 이 항을 T(n - 1)이라 할 때,
     * N - T(n - 1) = a(1) * n이다. (단, N - T(n - 1) >= 0이어야 한다)
     *
     * 즉, 주어진 N에 대해 1부터 i까자의 합을 N에서 뺀 값을 다시 i로 나눈 나머지가 0인 경우가 답에 속한다.
     *
     * T = n * (n + 1) / 2에 대해 n = [-1 + sqrt(1 + 8 * T)] / 2
     * -> n ~ sqrt(T) <= sqrt(N)
     * -> O(sqrt(N))
     */
    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int currentTotal = 0;

        for (int i = 1; currentTotal <= N; ++i) {
            currentTotal += i;

            if (currentTotal > N) {
                break;
            }

            if ((N - currentTotal) % i == 0) {
                ++answer;
            }
        }

        bw.write(String.valueOf(answer));
    }
}
