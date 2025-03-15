import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

        String source = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(source);
        Integer total = null;
        while (stringTokenizer.hasMoreTokens()) {
            int nextNum = Integer.parseInt(stringTokenizer.nextToken());
            if (total == null) {
                total = nextNum;
                continue;
            }
            total -= nextNum;
        }
        bw.write(String.valueOf(total));
        bw.flush();

        br.close();
        bw.close();
    }

}
