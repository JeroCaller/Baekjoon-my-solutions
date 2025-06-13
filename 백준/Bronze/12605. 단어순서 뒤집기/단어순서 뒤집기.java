import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

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
        final Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; ++i) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            while (stringTokenizer.hasMoreTokens()) {
                stack.push(stringTokenizer.nextToken());
            }

            StringBuilder stringBuilder = new StringBuilder("Case #")
                .append(i + 1)
                .append(": ");
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop()).append(" ");
            }
            bw.write(stringBuilder.toString().trim());
            bw.newLine();
            stack.clear();
        }
    }
}