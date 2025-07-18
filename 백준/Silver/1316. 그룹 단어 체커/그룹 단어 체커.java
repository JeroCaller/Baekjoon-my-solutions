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
        List<Character> charList = new ArrayList<>();
        int answer = 0;

        outer: for (int i = 0; i < N; ++i) {
            charList.clear();
            String source = br.readLine();

            for (int j = 0; j < source.length(); ++j) {
                char currentChar = source.charAt(j);
                if (j >= 2 &&
                    (charList.get(j - 1) != currentChar) &&
                    (charList.subList(0, j - 1).contains(currentChar))) {
                    continue outer;
                }
                charList.add(currentChar);
            }
            ++answer;
        }

        bw.write(String.valueOf(answer));
    }
}