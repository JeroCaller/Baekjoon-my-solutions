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
     * row (r)  |  values ( V(r, t) )
     * 1      1/1
     * 2      1/2 2/1
     * 3      3/1 2/2 1/3
     * 4      1/4 2/3 3/2 4/1
     * 5      5/1 4/2 3/3 2/4 1/5
     * 6      1/6 2/5 3/4 4/3 5/2 6/1
     * ...
     *
     * Let S(r) = r(r + 1)/2 and assume that we should find r where S(r) <= X.
     * then, r = floor((-1 + sqrt(1 + 8X)) / 2)
     * Let value at X be V(r, t) where t = X - S(r) then,
     *
     * case S(r) < X
     * if r is odd, V(r, t) = t / (r + 2 - t)
     * if r is even, V(r, t) = (r + 2 - t) / t
     *
     * case S(r) = X
     * if r is odd, V(r, t) = 1 / r
     * if r is even, V(r, t) = r / 1
     *
     * ex) X = 11, r = floor((-1 + sqrt(1 + 88)) / 2) = floor(8.43 / 2) = floor(4.215) = 4
     * S(r=4) = 10, t = X - S(r) = 11 - 10 = 1
     * V(r=4, t=1) = (4 + 2 - 1) / 1 = 5 / 1
     */
    public static void mySolution() throws IOException {
        int x = Integer.parseInt(br.readLine());
        int r = findRow(x);
        int t = x - S(r);
        int numerator, denominator;

        if (t == 0) {
            if (r % 2 == 1) {
                numerator = 1;
                denominator = r;
            } else {
                numerator = r;
                denominator = 1;
            }
        } else {
            if (r % 2 == 1) {
                numerator = t;
                denominator = r + 2 - t;
            } else {
                numerator = r + 2 - t;
                denominator = t;
            }
        }
        
        bw.write(numerator + "/" + denominator);
    }

    public static int findRow(int x) {
        return (int) Math.floor((-1 + Math.sqrt(1 + 8 * x)) / 2);
    }

    public static int S(int n) {
        return (n * (n + 1)) / 2;
    }
}