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
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            boolean[] isUnlocked = new boolean[n + 1];
            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= n; ++k) {
                    int next = j * k;
                    if (next <= n) {
                        isUnlocked[next] = !isUnlocked[next];
                    } else {
                        break;
                    }
                }
            }

            int answer = 0;
            for (int l = 1; l <= n; ++l) {
                if (isUnlocked[l]) {
                    ++answer;
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
    }

}