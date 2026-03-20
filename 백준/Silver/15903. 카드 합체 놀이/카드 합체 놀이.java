import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static long n, m;
    private static final PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Long.parseLong(inputs[0]);
        m = Long.parseLong(inputs[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        bw.write(String.valueOf(getAnswer()));
    }

    private static long getAnswer() {
        long total = 0;

        for (int i = 0; i < m; ++i) {
            long newNumber = pq.poll() + pq.poll();
            pq.offer(newNumber);
            pq.offer(newNumber);
        }

        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        return total;
    }
}
