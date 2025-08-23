import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

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
        String[] studentsId = new String[N];

        for (int i = 0; i < N; ++i) {
            studentsId[i] = br.readLine();
        }

        final int L = studentsId[0].length();
        Set<String> subStrSet = new HashSet<>();

        for (int i = L - 1; i >= 0; --i) {
            for (int j = 0; j < N; ++j) {
                subStrSet.add(studentsId[j].substring(i, L));
            }

            if (subStrSet.size() == N) {
                bw.write(String.valueOf(L - i));
                return;
            }

            subStrSet.clear();
        }
    }
}
