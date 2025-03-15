import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(source);
        Double total = null;
        while (stringTokenizer.hasMoreTokens()) {
            int nextNum = Integer.parseInt(stringTokenizer.nextToken());
            if (total == null) {
                total = (double) nextNum;
                continue;
            }
            total /= nextNum;
        }

        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
    }

}
