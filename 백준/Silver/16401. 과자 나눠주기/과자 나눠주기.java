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

    private static int n, m;
    private static int[] snacks;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        snacks = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        int maxSnack = 0;

        for (int i = 0; i < n; ++i) {
            snacks[i] = Integer.parseInt(st.nextToken());
            maxSnack = Math.max(maxSnack, snacks[i]);
        }

        int answer = getAnswer(1, maxSnack);
        bw.write(String.valueOf(answer));
    }

    private static boolean check(int criteria) {
        int count = 0;

        for (int snack : snacks) {
            if (criteria <= snack) {
                count += (snack / criteria);
            }
        }

        return count >= m;
    }

    private static int getAnswer(int startNum, int endNum) {
        int midNum = (startNum + endNum) / 2;
        int answer = 0;

        while (startNum <= endNum) {
            if (check(midNum)) {
                answer = Math.max(answer, midNum);
                startNum = midNum + 1;
            } else {
                endNum = midNum - 1;
            }

            midNum = (startNum + endNum) / 2;
        }

        return answer;
    }
}
