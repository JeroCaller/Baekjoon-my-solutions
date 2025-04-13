import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

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
        final String source = br.readLine();
        final int N = source.length() / 2;
        final Deque<Character> deque = new ArrayDeque<>();

        source.chars().forEach(value -> {
            deque.offerLast((char) value);
        });

        for (int i = 0; i < N; ++i) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                bw.write("0");
                return;
            }
        }

        bw.write("1");
    }

}
