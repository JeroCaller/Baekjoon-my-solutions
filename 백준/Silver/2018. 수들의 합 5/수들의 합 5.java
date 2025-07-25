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
     * 연속된 자연수의 개수를 k라 할 때,
     * k가 홀수일 경우,
     * 연속된 자연수들 중 가운데에 위치한 수를 a라 하면,
     * N = ... + (a - 2) + (a - 1) + a + (a + 1) + (a + 2) + ... = k * a
     * 즉, N의 약수들 중 홀수인 약수가 정답의 후보가 된다.
     *
     * 예) N = 15일 때
     * k = 1일 때, a = 15 => 15 = 15
     * k = 3일 때, a = 5 => 4 + 5 + 6 = 15
     * k = 5일 때, a = 3 => 1 + 2 + 3 + 4 + 5 = 15
     *
     * k가 짝수일 경우,
     * 연속된 자연수들 중 가운데에 위치한 두 수를 각각 a, (a + 1)이라 하면,
     * N = ...  + (a - 2) + (a - 1) + a + (a + 1) + (a + 2) + (a + 3) + ...
     * = k * a + (k / 2) = k * (a + 0.5)
     * => 2N = k * (2 * a + 1)
     * 이 때, k는 짝수이므로 임의의 자연수 m에 대해 k = 2 * m으로 표현하면...
     * N = m * (2 * a + 1) 인데,
     * 이 때 (2 * a + 1)은 a가 어떤 수라도 무조건 홀수이다. 따라서 이 경우에도 N의 약수들 중 홀수인 약수가
     * 정답의 후보가 된다.
     *
     * 예) N = 15일 때,
     * (2 * a + 1) = 15일 때, a = 7 => a + (a + 1) = 7 + 8 = 15
     *
     * 위 두 경우 모두 결과적으로 N의 약수들 중 홀수인 수들이 정답의 후보가 된다.
     * 따라서 N의 약수들 중 홀수인 수들의 개수가 곧 정답이다.
     *
     * 예) N = 15일 때, 약수는 모두 [1, 3, 5, 15]인데, 홀수인 약수의 개수는 4개이다.
     * 앞서 모든 홀수인 약수의 경우에 대해 각각 4 + 5 + 6, 1 + 2 + 3 + 4 + 5 등 대응되는 연속된 자연수들의 경우가
     * 있으므로 정답은 4이다.
     *
     * O(sqrt(N))
     *
     */
    public static void mySolution() throws IOException {
        final int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                if (i % 2 == 1) {
                    ++answer;
                }

                if (N / i != i && (N / i) % 2 == 1) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}
