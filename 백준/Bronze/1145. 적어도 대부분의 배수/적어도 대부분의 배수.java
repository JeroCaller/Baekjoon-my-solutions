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
        final int N = 5;
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int minLcm = -1;
        for (int i = 0; i <= N - 3; ++i) {
            for (int j = i + 1; j <= N - 2; ++j) {
                int lcmFirst = getLcm(numbers[i], numbers[j]);
                int lcmSecond = 0;
                for (int k = j + 1; k < N; ++k) {
                    lcmSecond = getLcm(lcmFirst, numbers[k]);
                    if (minLcm == -1 || minLcm > lcmSecond) {
                        minLcm = lcmSecond;
                    }
                }
            }
        }
        bw.write(String.valueOf(minLcm));
    }

    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    public static int getLcm(int a, int b) {
        int gcd = getGcd(a, b);
        return (a * b) / gcd;
    }
}