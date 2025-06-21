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
        String source = br.readLine();
        int answer = 0;

        for (int i = 0; i < source.length(); ++i) {
            int number = source.charAt(i) - '0';
            answer += pow(number, 5);
        }
        bw.write(String.valueOf(answer));
    }

    public static int pow(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            exp /= 2;
            base *= base;
        }
        return result;
    }
}