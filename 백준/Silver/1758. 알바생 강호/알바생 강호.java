import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        final List<Integer> tips = new ArrayList<>();
        long answer = 0;

        for (int i = 0; i < N; ++i) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort((t1, t2) -> t2 - t1);

        for (int i = 0; i < N; ++i) {
            answer += Math.max(tips.get(i) - i, 0);
        }

        bw.write(String.valueOf(answer));
    }
}

