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
        final int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; ++i) {
            queue.offer(i);
        }

        if (queue.size() == 1) {
            bw.write(String.valueOf(queue.poll()));
            return;
        }

        while (queue.size() > 1) {
            int discard = queue.poll();
            bw.write(discard + " ");

            if (queue.size() == 1) {
                bw.write(String.valueOf(queue.poll()));
                break;
            }

            queue.offer(queue.poll());
        }
    }
}
