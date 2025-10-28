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
        final int N = Integer.parseInt(br.readLine());
        int[] series = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            series[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int pivotIndex = -1;

        for (int i = N - 1; i >= 1; --i) {
            if (series[i - 1] < series[i]) {
                pivotIndex = i - 1;
                break;
            }
        }

        if (pivotIndex == -1) {
            bw.write("-1");
            return;
        }

        for (int i = N - 1; i > pivotIndex; --i) {
            if (series[pivotIndex] < series[i]) {
                swap(series, pivotIndex, i);
                break;
            }
        }

        for (int i = pivotIndex + 1; i < (pivotIndex + 1 + N) / 2; ++i) {
            swap(series, i, N - (i - pivotIndex));
        }

        for (int num : series) {
            bw.write(num + " ");
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

