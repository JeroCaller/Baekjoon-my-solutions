import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

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
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int K = Integer.parseInt(inputs[1]);
        final String DELIMITER = ", ";
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder("<");

        for (int i = 1; i <= N; ++i) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; ++i) {
                queue.offer(queue.poll());
            }
            stringBuilder.append(queue.poll())
                .append(DELIMITER);
        }

        stringBuilder.delete(stringBuilder.length() - DELIMITER.length(), stringBuilder.length())
            .append(">");

        bw.write(stringBuilder.toString());
    }
}
