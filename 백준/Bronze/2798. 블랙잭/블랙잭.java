import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
        int[] numbers = new int[N];
        String[] numbersLine = br.readLine().split(" ");

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        Arrays.sort(numbers);

        int answer = numbers[0] + numbers[1] + numbers[2];
        outer: for (int i = 1; i <= N - 2; ++i) {
            int leftIdx = 0;
            int rightIdx = N - 1;

            while (leftIdx < i && i < rightIdx) {
                int currentSum = numbers[leftIdx] +
                    numbers[i] +
                    numbers[rightIdx];
                if (currentSum == M) {
                    answer = currentSum;
                    break outer;
                }

                if (answer < currentSum) {
                    if (currentSum < M) {
                        answer = currentSum;
                        ++leftIdx;
                    } else {
                        --rightIdx;
                    }
                } else {
                    ++leftIdx;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}