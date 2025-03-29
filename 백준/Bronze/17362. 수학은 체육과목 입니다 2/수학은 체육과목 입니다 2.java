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
        int n = Integer.parseInt(br.readLine());
        int x = getAnswer(n);

        bw.write(String.valueOf(x));
    }

    public static int getAnswer(int n) {
        // 정답을 x라 할 때, n > 5에 대하여 (n - 5) / 4의 몫 q와 나머지 r에 대해,
        // q가 짝수인 경우, x = 5 - r,
        // q가 홀수인 경우, x = r + 1이다.

        int q, r;

        if (n <= 5) {
            return n;
        }

        q = (n - 5) / 4;
        r = (n - 5) % 4;

        return (q % 2 == 0) ? (5 - r) : (r + 1);
    }

}
