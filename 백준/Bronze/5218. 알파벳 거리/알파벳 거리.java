import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        final int T = Integer.parseInt(br.readLine());
        final List<Integer> distancesList = new ArrayList<>();

        for (int i = 0; i < T; ++i) {
            String[] words = br.readLine().split(" ");
            for (int j = 0; j < words[0].length(); ++j) {
                char x = words[0].charAt(j);
                char y = words[1].charAt(j);
                int distance = (x <= y) ? (y - x) : (y + 26 - x);
                distancesList.add(distance);
            }

            StringBuilder stringBuilder = new StringBuilder("Distances: ");
            for (int dist : distancesList) {
                stringBuilder.append(dist).append(" ");
            }
            bw.write(stringBuilder.toString().trim());
            bw.newLine();

            distancesList.clear();
        }
    }
}