import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
        boolean[][] papers = new boolean[N][N];  // blue: true, white: false

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; ++j) {
                papers[i][j] = st.nextToken().equals("1");
            }
        }

        int[] results = search(papers, new Interval(0, N - 1, 0, N - 1));

        for (int num : results) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }
    }

    private static int[] search(boolean[][] papers, Interval interval) {
        int[] results = {0, 0};  // white, blue
        boolean color = papers[interval.getY1()][interval.getX1()];

        for (int y = interval.getY1(); y <= interval.getY2(); ++y) {
            for (int x = interval.getX1(); x <= interval.getX2(); ++x) {
                if (color != papers[y][x]) {
                    List<Interval> intervals = new ArrayList<>();
                    intervals.add(new Interval(
                        interval.getX1(), interval.getX1() + interval.getLength() / 2 - 1,
                        interval.getY1(), interval.getY1() + interval.getLength() / 2 - 1
                    ));
                    intervals.add(new Interval(
                        interval.getX1() + interval.getLength() / 2, interval.getX2(),
                        interval.getY1(), interval.getY1() + interval.getLength() / 2 - 1
                    ));
                    intervals.add(new Interval(
                        interval.getX1(), interval.getX1() + interval.getLength() / 2 - 1,
                        interval.getY1()  + interval.getLength() / 2, interval.getY2()
                    ));
                    intervals.add(new Interval(
                        interval.getX1() + interval.getLength() / 2, interval.getX2(),
                        interval.getY1() + interval.getLength() / 2, interval.getY2()
                    ));

                    for (Interval nextInterval : intervals) {
                        int[] subResults = search(papers, nextInterval);
                        results[0] += subResults[0];
                        results[1] += subResults[1];
                    }

                    return results;
                }
            }
        }

        results[color ? 1 : 0]++;
        return results;
    }
}

class Interval {
    private int x1, x2, y1, y2;

    public Interval(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() { return x1; }
    public int getX2() { return x2; }
    public int getY1() { return y1; }
    public int getY2() { return y2; }
    public int getLength() { return Math.abs(x2 - x1) + 1; }
}
