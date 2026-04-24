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
    private static int[][] table;
    private static final List<List<Integer>> allCases = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; ++j) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> initCase = new ArrayList<>();
        initCase.add(0);
        visited[0] = true;
        generateCases(initCase, 1);
        bw.write(String.valueOf(getMinDiff()));
    }

    private static void generateCases(List<Integer> oneCase, int startNum) {
        if (oneCase.size() == n / 2) {
            List<Integer> oneCaseCopy = new ArrayList<>(oneCase);

            for (int i = 0; i < n; ++i) {
                if (!visited[i]) {
                    oneCaseCopy.add(i);
                }
            }

            allCases.add(oneCaseCopy);
            return;
        }

        for (int i = startNum; i < n; ++i) {
            oneCase.add(i);
            visited[i] = true;
            generateCases(oneCase, i + 1);
            oneCase.remove(oneCase.size() - 1);
            visited[i] = false;
        }
    }

    private static int getMinDiff() {
        int minDiff = -1;

        for (List<Integer> oneCase : allCases) {
            int diff = Math.abs(
                getSum(oneCase, 0, n / 2) -
                getSum(oneCase, n / 2, n)
            );

            if (minDiff == -1) {
                minDiff = diff;
            } else {
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }

    private static int getSum(List<Integer> oneCase, int leftIdx, int rightIdx) {
        int sum = 0;

        for (int i = leftIdx; i < rightIdx; ++i) {
            for (int j = i + 1; j < rightIdx; ++j) {
                int iNum = oneCase.get(i);
                int jNum = oneCase.get(j);
                sum += table[iNum][jNum] + table[jNum][iNum];
            }
        }

        return sum;
    }
}
