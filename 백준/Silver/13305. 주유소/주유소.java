import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer lengthTokenizer = new StringTokenizer(br.readLine(), " ");
        StringTokenizer citiesTokenizer = new StringTokenizer(br.readLine(), " ");
        int currentLeastCost = 1000000000;
        long totalCost = 0;

        for (int i = 0; i < N - 1; ++i) {
           int nextLength = Integer.parseInt(lengthTokenizer.nextToken());
           int currentCity = Integer.parseInt(citiesTokenizer.nextToken());

           if (currentLeastCost > currentCity) {
               currentLeastCost = currentCity;
           }

           totalCost += (long) currentLeastCost * nextLength;
        }

        bw.write(String.valueOf(totalCost));
    }
}
