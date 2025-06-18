import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[N];
        List<Integer> gcds = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int gcd = getGCD(nums[i], nums[j]);
                if (!gcds.contains(gcd)) {
                    gcds.add(gcd);
                }
            }
        }
        gcds.sort((n1, n2) -> n1 - n2);

        List<Integer> divisors = getDivisors(gcds.get(0));
        for (int divisor : divisors) {
            bw.write(String.valueOf(divisor));
            bw.newLine();
        }
    }

    public static int getGCD(int a, int b) {
        if (a * b == 0) return Math.max(a, b);

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int r = a % b;
        if (r == 0) {
            return b;
        }

        return getGCD(b, r);
    }

    public static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                divisors.add(i);
                int q = n / i;
                if (q != i) {
                    divisors.add(q);
                }
            }
        }
        divisors.sort((n1, n2) -> n1 - n2);

        return divisors;
    }
}