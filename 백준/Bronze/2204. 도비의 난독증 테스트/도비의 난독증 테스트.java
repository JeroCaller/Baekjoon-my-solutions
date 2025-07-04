import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

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
        // lowercase, original
        TreeMap<String, String> map = new TreeMap<>((a, b) -> a.compareTo(b));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String input;
            for (int i = 0; i < n; ++i) {
                input = br.readLine();
                map.put(input.toLowerCase(), input);
            }

            bw.write(map.firstEntry().getValue());
            bw.newLine();

            map.clear();
        }
    }
}