import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = -1;
        String source;
        while (true) {
            source = br.readLine();
            if (source.isBlank()) break;

            n = Integer.parseInt(source);
            if (n == 0) break;
            bw.write(String.valueOf(sumOnetoN(n)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int sumOnetoN(int n) {
        return n * (n + 1) / 2;
    }

}
