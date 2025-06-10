import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

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
        // 변환 후, 변환 전
        Map<Character, Character> caesarMap = new HashMap<>();
        final int totalChar = 'Z' - 'A' + 1;
        for (int i = 0; i < totalChar; ++i) {
            char original = (char) ('A' + i);
            char converted = (char) (((original - 'A' + 3) % totalChar) + 'A');
            caesarMap.put(converted, original);
        }

        String source = br.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); ++i) {
            stringBuilder.append(caesarMap.get(source.charAt(i)));
        }
        bw.write(stringBuilder.toString());
    }

}