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
        /*
        case 1) N이 2의 제곱수가 아닌 경우. (홀수, 짝수는 상관없음)
        1. N보다 작으면서도 N과 가장 가까운 2의 제곱수가 정답이다.

        case 2) N이 2의 제곱수인 경우.
        1. N이 정답이다.
        */
        final int N = Integer.parseInt(br.readLine());
        if (isPowerOfTwo(N)) {
            bw.write(String.valueOf(N));
        } else {
            bw.write(String.valueOf(Integer.highestOneBit(N)));
        }
    }

    public static boolean isPowerOfTwo(int n) {
        return Integer.toBinaryString(n & (n - 1)).equals("0");
    }
}