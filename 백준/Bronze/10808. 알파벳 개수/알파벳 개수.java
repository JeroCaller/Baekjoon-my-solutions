import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();
        int[] counters = new int[26];

        int indexForCounters;
        char target;
        for (int i = 0; i < source.length(); ++i) {
            target = source.charAt(i);
            indexForCounters = extractIndexofChar(target);
            ++counters[indexForCounters];
        }

        String result = resultToString(counters);
        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }

    public static int extractIndexofChar(char target) {
        char a = 'a';
        return target - a;
    }

    public static String resultToString(int[] counters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int counter : counters) {
            stringBuilder.append(counter).append(" ");
        }

        return stringBuilder.toString();

    }

}
