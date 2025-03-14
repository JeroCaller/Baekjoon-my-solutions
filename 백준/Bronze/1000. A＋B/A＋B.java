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
        int total = 0;
        while (stringTokenizer.hasMoreTokens()) {
            total += Integer.parseInt(stringTokenizer.nextToken());
        }
        bw.write(String.valueOf(total));
        bw.flush();

        br.close();
        bw.close();
    }

}