import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int X = Integer.parseInt(firstLine[1]);

        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer seriesTokens = new StringTokenizer(br.readLine());
        int currentNum = 0;
        while (seriesTokens.hasMoreTokens()) {
            currentNum = Integer.parseInt(seriesTokens.nextToken());
            if (currentNum < X) {
                stringBuilder.append(String.valueOf(currentNum))
                    .append(" ");
            }
        }

        bw.write(stringBuilder.toString().trim());

        bw.flush();
        bw.close();
        br.close();
    }

}
