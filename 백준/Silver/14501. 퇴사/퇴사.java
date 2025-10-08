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
        final int N = Integer.parseInt(br.readLine());
        DayInfo[] dayInfos = new DayInfo[N + 1];
        int[] profits = new int[N + 2];  // profits[N + 1] = 0;

        for (int i = 1; i <= N; ++i) {
            String[] inputs = br.readLine().split(" ");
            dayInfos[i] = new DayInfo(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        for (int i = N; i >= 1; --i) {
            int nextDay = i + dayInfos[i].getTime();

            if (nextDay > N + 1) {
                profits[i] = profits[i + 1];
            } else {
                profits[i] = Math.max(profits[i + 1], dayInfos[i].getPrice() + profits[nextDay]);
            }
        }

        bw.write(String.valueOf(profits[1]));
    }
}

class DayInfo {

    private int time;
    private int price;

    public DayInfo(int time, int price) {
        this.time = time;
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }
}
