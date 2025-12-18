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

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        int[] trees = new int[N];
        int maxTree = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            trees[i] = Integer.parseInt(stringTokenizer.nextToken());

            if (trees[i] > maxTree) {
                maxTree = trees[i];
            }
        }

        int result = findAnswer(trees, maxTree, M);
        bw.write(String.valueOf(result));
    }

    private static boolean isCandidate(int[] trees, int m, int offer) {
        long total = 0;

        for (int i = 0; i < trees.length; ++i) {
            if (trees[i] < offer) {
                continue;
            }

            total += trees[i] - offer;
        }

        return total >= m;
    }

    private static int findAnswer(int[] trees, int maxTree, int m) {
        int leftIdx = 0;
        int rightIdx = maxTree;
        int midIdx = (leftIdx + rightIdx) / 2;
        int answer = 0;

        while (leftIdx <= rightIdx) {
            if (isCandidate(trees, m, midIdx)) {
                answer = Math.max(answer, midIdx);
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }

            midIdx = (leftIdx + rightIdx) / 2;
        }

        return answer;
    }
}
