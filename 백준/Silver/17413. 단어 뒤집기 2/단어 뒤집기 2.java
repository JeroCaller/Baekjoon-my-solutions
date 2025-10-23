import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
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
        String input = br.readLine();
        Matcher matcher = Pattern.compile("<[a-z\\s]+>").matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        int lastEndPointer = 0;

        while (matcher.find()) {
            stringBuilder.append(getReversedAllTokens(
                input.substring(lastEndPointer, matcher.start())
            ))
                .append(input, matcher.start(), matcher.end());
            lastEndPointer = matcher.end();
        }

        stringBuilder.append(getReversedAllTokens(input.substring(lastEndPointer)));
        bw.write(stringBuilder.toString());
    }

    private static String getReversedAllTokens(String original) {
        StringTokenizer stringTokenizer = new StringTokenizer(original, " ");
        StringBuilder stringBuilder = new StringBuilder();

        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.append(getReversedString(stringTokenizer.nextToken()))
                .append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private static String getReversedString(String original) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = original.length() - 1; i >= 0; --i) {
            stringBuilder.append(original.charAt(i));
        }

        return stringBuilder.toString();
    }
}
