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
        long s = Long.parseLong(br.readLine());
        bw.write(String.valueOf(getNForSn(s)));
    }

    /**
     * S(n) = n(n + 1) / 2 일 때 S(n)이 주어졌을 때 이를 만족하는
     * n을 찾는 메서드.
     * n에 소수점이 있는 경우 n보다 작은 자연수들 중 가장 큰 수를 반환.
     *
     * @param sn
     * @return
     */
    private static long getNForSn(long sn) {
        return (long) ((-1 + Math.sqrt(1 + 8 * sn)) / 2);
    }
}
