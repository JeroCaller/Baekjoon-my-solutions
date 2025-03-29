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
        String[] source = br.readLine().split("");
        int result = getAnswer(source);
        bw.write(String.valueOf(result));
    }

    public static int getAnswer(String[] source) {
        switch (source.length) {
            case 2:
                return getParsedInt(source[0]) + getParsedInt(source[1]);
            case 3:
                int notTen = (source[1].equals("0")) ?
                    getParsedInt(source[2]) : getParsedInt(source[0]);
                return 10 + notTen;
            case 4:
                return 20;
        }
        return -1;
    }

    public static int getParsedInt(String str) {
        return Integer.parseInt(str);
    }

}
