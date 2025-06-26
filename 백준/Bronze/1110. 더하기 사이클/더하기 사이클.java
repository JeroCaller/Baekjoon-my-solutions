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
        String original = br.readLine();

        int counter = 0;
        String beforeNumStr = original;
        String afterNumStr = "";

        while (!original.equals(afterNumStr)) {
            afterNumStr = "";
            int mergedNum = 0;
            for (int i = 0; i < beforeNumStr.length(); ++i) {
                mergedNum += beforeNumStr.charAt(i) - '0';
            }

            String mergedNumStr = String.valueOf(mergedNum);
            if (beforeNumStr.charAt(beforeNumStr.length() - 1) != '0') {
                afterNumStr += beforeNumStr.charAt(beforeNumStr.length() - 1);
            }
            afterNumStr += mergedNumStr.charAt(mergedNumStr.length() - 1);
            
            beforeNumStr = afterNumStr;
            ++counter;
        }
        bw.write(String.valueOf(counter));
    }
}