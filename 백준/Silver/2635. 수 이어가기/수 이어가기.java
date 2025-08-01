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
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int maxLength = 0;

        for (int i = 0; i <= N; ++i) {
            int first = N;
            int second = i;

            queue.offer(first);
            queue.offer(second);

            while (first - second >= 0) {
                queue.offer(first - second);

                int temp = first;
                first = second;
                second = temp - second;
            }

            if (maxLength < queue.size()) {
                maxLength = queue.size();
                stringBuilder.setLength(0);

                while (!queue.isEmpty()) {
                    stringBuilder.append(queue.poll()).append(" ");
                }
            }

            queue.clear();
        }

        bw.write(String.valueOf(maxLength));
        bw.newLine();
        bw.write(stringBuilder.toString().trim());
    }
}
