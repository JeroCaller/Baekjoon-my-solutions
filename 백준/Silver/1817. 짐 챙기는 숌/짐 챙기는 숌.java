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

        int answer = 0;

        if (N == 0) {
            bw.write(String.valueOf(answer));
            return;
        }

        int currentBooksInBox = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        while (stringTokenizer.hasMoreTokens()) {
            int bookWeight = Integer.parseInt(stringTokenizer.nextToken());
            int ifAdded = currentBooksInBox + bookWeight;

            if (bookWeight > M) {
                continue;
            }

            if (ifAdded > M) {
                ++answer;
                currentBooksInBox = bookWeight;
            } else if (ifAdded == M) {
                ++answer;
                currentBooksInBox = 0;
            } else {
                currentBooksInBox = ifAdded;
            }
        }

        if (currentBooksInBox > 0) {
            ++answer;
        }

        bw.write(String.valueOf(answer));
    }
}
