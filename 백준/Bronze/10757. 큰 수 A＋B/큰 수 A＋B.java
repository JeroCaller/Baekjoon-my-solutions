import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        BigInteger result = BigInteger.ZERO;
        while (stringTokenizer.hasMoreTokens()) {
            result = result.add(new BigInteger(stringTokenizer.nextToken()));
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
