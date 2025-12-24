import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        int[] givenSeries = new int[N];
        int seriesIndex = 0;

        for (int i = 0; i < N; ++i) {
            givenSeries[i] = Integer.parseInt(br.readLine());
        }

        List<String> results = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int nextNum = 1;

        while (seriesIndex < N) {
            if (stack.isEmpty() || stack.peek() < givenSeries[seriesIndex]) {
                stack.push(nextNum++);
                results.add("+");
            } else if (stack.peek() == givenSeries[seriesIndex]) {
                stack.pop();
                results.add("-");
                ++seriesIndex;
            } else if (stack.peek() > givenSeries[seriesIndex]) {
                bw.write("NO");
                return;
            }
        }

        for (String result : results) {
            bw.write(result);
            bw.newLine();
        }
    }
}
