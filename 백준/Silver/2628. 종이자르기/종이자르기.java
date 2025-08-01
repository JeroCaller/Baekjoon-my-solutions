import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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
        String[] sizes = br.readLine().split(" ");
        final int W = Integer.parseInt(sizes[0]);
        final int H = Integer.parseInt(sizes[1]);
        final int N = Integer.parseInt(br.readLine());
        List<Integer> rowToCut = new ArrayList<>();
        List<Integer> columnToCut = new ArrayList<>();

        rowToCut.add(0);
        rowToCut.add(H);
        columnToCut.add(0);
        columnToCut.add(W);

        for (int i = 0; i < N; ++i) {
            String[] inputs = br.readLine().split(" ");
            int cutPoint = Integer.parseInt(inputs[1]);

            if (inputs[0].equals("0")) {
                rowToCut.add(cutPoint);
            } else {
                columnToCut.add(cutPoint);
            }
        }

        Collections.sort(rowToCut);
        Collections.sort(columnToCut);

        int maxArea = 0;

        for (int i = 0; i < rowToCut.size() - 1; ++i) {
            for (int j = 0; j < columnToCut.size() - 1; ++j) {
                int width = columnToCut.get(j + 1) - columnToCut.get(j);
                int height = rowToCut.get(i + 1) - rowToCut.get(i);
                int area = width * height;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        bw.write(String.valueOf(maxArea));
    }
}
