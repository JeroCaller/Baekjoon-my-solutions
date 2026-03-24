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
        final int[] infos = new int[N];
        final int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            infos[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            int j = 0;

            while (infos[i] + j < N) {
                if (answer[infos[i] + j] == 0) {
                    int numOfZeros = 0;

                    for (int k = 0; k < infos[i] + j; ++k) {
                        if (answer[k] == 0) {
                            numOfZeros++;
                        }
                    }

                    if (numOfZeros >= infos[i]) {
                        answer[infos[i] + j] = (i + 1);
                        break;
                    }
                }

                j++;
            }
        }

        for (int i = 0; i < N; ++i) {
            bw.write(answer[i] + " ");
        }
    }
}
