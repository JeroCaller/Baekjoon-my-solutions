import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int k;
    private static int[] s;
    private static final int R = 6;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            s = new int[k];

            for (int i = 0; i < k; ++i) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            search(new ArrayList<>(), 0);
            bw.newLine();
        }
    }

    private static void search(List<Integer> oneResult, int startIdx) throws IOException {
        if (oneResult.size() == R) {
            for (int num : oneResult) {
                bw.write(num + " ");
            }

            bw.newLine();
            return;
        }

        for (int i = startIdx; i < k; ++i) {
            oneResult.add(s[i]);
            search(oneResult, i + 1);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}
