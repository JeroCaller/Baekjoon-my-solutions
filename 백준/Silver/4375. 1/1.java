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
        O(1) = 1, O(2) = 11, O(3) = 111, ...

        11 = 1 * 10 + 1, 111 = 11 * 10 + 1, 1111 = 111 * 10 + 1, ...
        => O(i) = O(i-1) * 10 + 1

        O(i-1) = nQ + r(i-1)

        r(i) = O(i) % n = {O(i-1) * 10 + 1} % n
            = [{nQ + r(i-1)} * 10 + 1} % n
            = [r(i-1) * 10 + 1] % n
         */

        while(true) {
            String input = br.readLine();

            if (input == null || input.isEmpty()) {
                break;
            }

            int num = Integer.parseInt(input);
            int count = 0;
            int r = 1 % num;

            while (r != 0) {
                r = (r * 10 + 1) % num;
                ++count;
            }

            bw.write(String.valueOf(count + 1));
            bw.newLine();
        }
    }
}
