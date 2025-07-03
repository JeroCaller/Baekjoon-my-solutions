import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        String[] xy = br.readLine().split(" ");
        final int X = Integer.parseInt(xy[0]);
        final int Y = Integer.parseInt(xy[1]);

        int[] endDays = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayDiff = 0;

        for (int i = 1; i < X; ++i) {
            dayDiff += endDays[i];
        }
        dayDiff += Y;

        String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        bw.write(daysOfWeek[dayDiff % 7]);
    }
}