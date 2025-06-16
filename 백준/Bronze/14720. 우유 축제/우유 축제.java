import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 2);
        map.put(2, 0);
        Stack<Integer> stack = new Stack<>();
        stack.push(2);  // 계산 편의용. 모든 계산이 끝난 후에는 스택 개수에서 이 값은 제외.

        while (stringTokenizer.hasMoreTokens()) {
            int market = Integer.parseInt(stringTokenizer.nextToken());
            if (market == map.get(stack.peek())) {
                stack.push(market);
            }
        }

        bw.write(String.valueOf(stack.size() - 1));
    }
}