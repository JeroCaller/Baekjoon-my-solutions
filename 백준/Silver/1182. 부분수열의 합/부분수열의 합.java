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
        String[] conditions = br.readLine().split(" ");
        final int N = Integer.parseInt(conditions[0]);
        final int S = Integer.parseInt(conditions[1]);
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = countNumberOfCases(nums, S);
        bw.write(String.valueOf(answer));
    }

    public static int countNumberOfCases(int[] nums, int s) {
        int count = 0;
        Stack<Info> stack = new Stack<>();

        for (int i = 0; i < nums.length; ++i) {
            Info info = new Info(i, nums[i]);
            stack.push(info);
        }

        while (!stack.isEmpty()) {
            Info info = stack.pop();

            if (info.getTotal() == s) {
                ++count;
            }

            for (int i = info.getMaxIndex() + 1; i < nums.length; ++i) {
                Info nextInfo = new Info(i, info.getTotal() + nums[i]);
                stack.push(nextInfo);
            }
        }

        return count;
    }
}

class Info {
    private int maxIndex;
    private int total;

    public Info(int maxIndex, int total) {
        this.maxIndex = maxIndex;
        this.total = total;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public int getTotal() {
        return total;
    }
}