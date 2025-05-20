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
        int[][] points = new int[3][2];
        for (int i = 0; i < 3; ++i) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; ++j) {
                points[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        Map<Integer, Integer> xFrequency = new HashMap<>();
        Map<Integer, Integer> yFrequency = new HashMap<>();

        for (int[] point : points) {
            if (xFrequency.containsKey(point[0])) {
                xFrequency.put(point[0], xFrequency.get(point[0]) + 1);
            } else {
                xFrequency.put(point[0], 1);
            }

            if (yFrequency.containsKey(point[1])) {
                yFrequency.put(point[1], yFrequency.get(point[1]) + 1);
            } else {
                yFrequency.put(point[1], 1);
            }
        }

        int[] results = new int[2];

        xFrequency.forEach((key, value) -> {
            if (value == 1) {
                results[0] = key;
            }
        });
        yFrequency.forEach((key, value) -> {
            if (value == 1) {
                results[1] = key;
            }
        });

        for (int result: results) {
            bw.write(String.valueOf(result) + " ");
        }

    }

}
