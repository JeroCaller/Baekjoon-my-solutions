import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalTime;

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
        String[] currentTimeStrings = br.readLine().split(" ");
        LocalTime currentTime = LocalTime.of(
            Integer.parseInt(currentTimeStrings[0]),
            Integer.parseInt(currentTimeStrings[1]),
            Integer.parseInt(currentTimeStrings[2])
        );

        long cookTimeInSeconds = Long.parseLong(br.readLine());
        LocalTime resultTime = currentTime.plusSeconds(cookTimeInSeconds);
        String result = String.format(
            "%d %d %d",
            resultTime.getHour(),
            resultTime.getMinute(),
            resultTime.getSecond()
        );
        bw.write(result);
    }

}
