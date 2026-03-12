import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int answer = search();

        if (answer == 0 && n != 1) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(answer));
        }
    }

    private static int search() {
        final Queue<Integer> queue = new ArrayDeque<>();  // index
        final int[] depth = new int[n];
        queue.offer(0);

        while (!queue.isEmpty() && depth[n - 1] == 0) {
            int idx = queue.poll();

            for (int i = 1; i <= array[idx]; ++i) {
                if (i + idx > n - 1) break;
                if (depth[i + idx] != 0) continue;

                queue.offer(i + idx);
                depth[i + idx] = depth[idx] + 1;
            }
        }

        return depth[n - 1];
    }
}
