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
        final int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 1, answer = 1;
        final int[] frequencies = new int[10];
        frequencies[nums[i]]++;

        while (j < N) {
            frequencies[nums[j]]++;

            if (getNumOfKinds(frequencies) > 2) {
                while (i < j) {
                    if (frequencies[nums[i]] > 0) {
                        frequencies[nums[i]] -= 1;
                        i++;
                    }

                    if (getNumOfKinds(frequencies) <= 2) {
                        break;
                    }
                }
            }

            answer = Math.max(answer, j - i + 1);
            j++;
        }

        bw.write(String.valueOf(answer));
    }

    private static int getNumOfKinds(int[] freq) {
        int count = 0;

        for (int i = 0; i < freq.length; ++i) {
            if (freq[i] > 0) {
                ++count;
            }
        }

        return count;
    }
}
