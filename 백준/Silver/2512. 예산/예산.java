import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int[] budgets;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        budgets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(br.readLine());
        int maxBudget = 0;

        for (int i = 0; i < n; ++i) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }

        bw.write(String.valueOf(search(maxBudget)));
    }

    private static boolean isPossible(int criteria) {
        int total = 0;

        for (int i = 0; i < n; ++i) {
            total += Math.min(budgets[i], criteria);
        }

        return m >= total;
    }

    private static int search(int maxRange) {
        int left = 0;
        int right = maxRange;
        long mid = (left + right) / 2;

        while (left <= right) {
            if (isPossible((int) mid)) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }

            mid = (left + right) / 2;
        }

        return (int) mid;
    }
}
