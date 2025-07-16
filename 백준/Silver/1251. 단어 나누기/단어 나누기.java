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
        String source = br.readLine();
        String result = null;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < source.length() - 1; ++i) {
            for (int j = i + 1; j < source.length(); ++j) {
                stringBuilder
                    .append(reverse(source.substring(0, i)))
                    .append(reverse(source.substring(i, j)))
                    .append(reverse(source.substring(j)));

                if (result == null || result.compareTo(stringBuilder.toString()) > 0) {
                    result = stringBuilder.toString();
                }

                stringBuilder.setLength(0);
            }

            stringBuilder.setLength(0);
        }

        bw.write(result);
    }

    public static String reverse(String source) {
        char[] chars = source.toCharArray();

        for (int i = 0; i < chars.length / 2; ++i) {
            int endIdx = chars.length - 1 - i;
            char temp = chars[i];
            chars[i] = chars[endIdx];
            chars[endIdx] = temp;
        }

        return String.valueOf(chars);
    }
}