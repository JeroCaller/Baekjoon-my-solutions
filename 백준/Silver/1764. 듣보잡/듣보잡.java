import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
        String[] firstLine = br.readLine().split(" ");
        final int N = Integer.parseInt(firstLine[0]);
        final int M = Integer.parseInt(firstLine[1]);
        final Set<String> notHeardSet = new HashSet<>();
        final List<String> notHeardAndSawList = new LinkedList<>();

        for (int i = 0; i < N; ++i) {
            notHeardSet.add(br.readLine());
        }

        String input;

        for (int i = 0; i < M; ++i) {
            input = br.readLine();

            if (notHeardSet.contains(input)) {
                notHeardAndSawList.add(input);
            }
        }

        notHeardAndSawList.sort(Comparator.naturalOrder());

        bw.write(String.valueOf(notHeardAndSawList.size()));
        bw.newLine();

        for (String name : notHeardAndSawList) {
            bw.write(name);
            bw.newLine();
        }
    }
}

