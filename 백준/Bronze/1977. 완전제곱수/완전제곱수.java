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
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        List<Integer> squareNumbers = new ArrayList<>();
        int m = (int) Math.round(Math.sqrt(M));
        int n = (int) Math.round(Math.sqrt(N));

        for (int i = m; i <= n; ++i) {
            int nextNumber = i * i;
            if (M <= nextNumber && nextNumber <= N) {
                squareNumbers.add(i * i);
            }
        }
        if (squareNumbers.isEmpty()) {
            bw.write(String.valueOf(-1));
            return;
        }
        int sum = squareNumbers.stream()
            .reduce(Integer::sum)
            .orElse(-1);
        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.write(String.valueOf(squareNumbers.get(0)));
    }
}