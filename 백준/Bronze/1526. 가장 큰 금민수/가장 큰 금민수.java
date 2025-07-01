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
        String numStr = br.readLine();
        int number = Integer.parseInt(numStr);
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '7');
        map.put('0', '4');

        StringBuilder binarySb = new StringBuilder();
        StringBuilder gumminSuSb = new StringBuilder();

        for (int i = numStr.length(); i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                binarySb.append('1');
            }

            int decimal = Integer.parseInt(binarySb.toString(), 2);
            int toGumminSu = 0;

            while (decimal >= 0) {
                for (int j = 0; j < binarySb.length(); ++j) {
                    gumminSuSb.append(map.get(binarySb.charAt(j)));
                }

                toGumminSu = Integer.parseInt(gumminSuSb.toString());
                if (toGumminSu <= number) {
                    bw.write(String.valueOf(toGumminSu));
                    return;
                }

                binarySb.setLength(0);
                String binStr = Integer.toBinaryString(--decimal);
                int numOfBitDiff = i - binStr.length();
                for (int j = 0; j < numOfBitDiff; ++j) {
                    binarySb.append('0');
                }
                binarySb.append(binStr);
                gumminSuSb.setLength(0);
            }

            binarySb.setLength(0);
        }
    }
}