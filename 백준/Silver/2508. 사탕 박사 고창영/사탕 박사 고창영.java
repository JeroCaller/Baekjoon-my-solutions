import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            br.readLine();
            String[] rc = br.readLine().split(" ");
            final int R = Integer.parseInt(rc[0]);
            final int C = Integer.parseInt(rc[1]);

            int answer = 0;
            String[] box = new String[R];
            String[] diagonalBox = new String[C];

            for (int j = 0; j < R; ++j) {
                box[j] = br.readLine();
            }

            for (int j = 0; j < C; ++j) {
                StringBuilder stringBuilder = new StringBuilder();

                for (int k = 0; k < R; ++k) {
                    stringBuilder.append(box[k].charAt(j));
                }

                diagonalBox[j] = stringBuilder.toString();
            }

            answer += getNumberOfCandy(box, "(>o<)");
            answer += getNumberOfCandy(diagonalBox, "(vo\\^)");

            bw.write(String.valueOf(answer));
            bw.newLine();

            /*
            for (int j = 0; j < C; ++j) {
                bw.write(diagonalBox[j]);
                bw.newLine();
            }
             */
        }
    }

    private static int getNumberOfCandy(String[] box, String regex) {
        Pattern pattern = Pattern.compile(regex);
        int count = 0;

        for (String line : box) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                ++count;
            }
        }

        return count;
    }
}
