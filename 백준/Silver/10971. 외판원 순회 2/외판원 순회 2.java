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

    private static int n;
    private static int[][] w;
    private static int cost;
    private static boolean[] hasVisited;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        hasVisited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; ++j) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(new ArrayList<>());
        bw.write(String.valueOf(cost));
    }

    private static void search(List<Integer> oneList) {
        if (oneList.size() == n) {
            int thisCost = 0;
            boolean notBroken = true;
            oneList.add(oneList.get(0));

            for (int i = 0; i < n; ++i) {
                if (w[oneList.get(i)][oneList.get(i + 1)] == 0) {
                    notBroken = false;
                    break;
                }

                thisCost += w[oneList.get(i)][oneList.get(i + 1)];
            }

            if (notBroken) {
                cost = (cost == 0) ? thisCost : Math.min(cost, thisCost);
            }

            oneList.remove(oneList.size() - 1);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (hasVisited[i]) continue;
            oneList.add(i);
            hasVisited[i] = true;
            search(oneList);
            oneList.remove(oneList.size() - 1);
            hasVisited[i] = false;
        }
    }
}
