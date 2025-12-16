import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        final int K = Integer.parseInt(firstLine[0]);
        final int N = Integer.parseInt(firstLine[1]);
        int maxLength = 0;
        int[] wires = new int[K];

        for (int i = 0; i < K; ++i) {
            wires[i] = Integer.parseInt(br.readLine());

            if (wires[i] > maxLength) {
                maxLength = wires[i];
            }
        }

        long result = findAnswer(wires, N, maxLength);
        bw.write(String.valueOf(result));
    }

    private static boolean isPossible(int[] wires, int n, long targetLength) {
        long count = 0;

        for (int i = 0; i < wires.length; ++i) {
            count += wires[i] / targetLength;
        }

        return count >= n;
    }

    private static long findAnswer(int[] wires, int n, long maxLength) {
        long answer = 1;
        long leftIdx = 1;
        long rightIdx = maxLength;
        long midIdx = (leftIdx + rightIdx) / 2;

        while (leftIdx <= rightIdx) {
            if (isPossible(wires, n, midIdx)) {
                leftIdx = midIdx + 1;
                answer = Math.max(answer, midIdx);
            } else {
                rightIdx = midIdx - 1;
            }

            midIdx = (leftIdx + rightIdx) / 2;
        }

        return answer;
    }
}
