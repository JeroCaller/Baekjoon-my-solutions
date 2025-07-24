import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String factResult = factorial(n).toString();
        Matcher matcher = Pattern.compile("0+$").matcher(factResult);

        String matcherResult = "";
        if (matcher.find()) {
            matcherResult = matcher.group();
        }

        bw.write(String.valueOf(matcherResult.length()));
    }

    private static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}
