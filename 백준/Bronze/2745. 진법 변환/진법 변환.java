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
        Map<Character, Integer> alphaTable = new HashMap<>();
        for (int i = 10; i < 10 + 26; ++i) {
            alphaTable.put((char)('A' + i - 10), i);
        }

        String[] input = br.readLine().split(" ");
        final int B = Integer.parseInt(input[1]);
        int answer = 0;
        for (int j = 0; j < input[0].length(); ++j) {
            char target = input[0].charAt(j);
            if (alphaTable.containsKey(target)) {
                answer += (int) (Math.pow(B, input[0].length() - (j + 1)) * alphaTable.get(target));
            } else {
                answer += (int) (Math.pow(B, input[0].length() - (j + 1)) * (target - '0'));
            }
        }

        bw.write(String.valueOf(answer));
    }
}