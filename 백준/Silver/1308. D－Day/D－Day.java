import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("y M d");
        LocalDate today = LocalDate.parse(br.readLine(), dateFormatter);
        LocalDate dDay = LocalDate.parse(br.readLine(), dateFormatter);

        long dayDiff = dDay.toEpochDay() - today.toEpochDay();

        if (dDay.getYear() - today.getYear() < 1000) {
            bw.write("D-" + dayDiff);
            return;
        }

        if (dDay.getYear() - today.getYear() > 1000) {
            bw.write("gg");
            return;
        }

        if (dDay.getMonthValue() < today.getMonthValue()) {
            bw.write("D-" + dayDiff);
            return;
        }

        if (dDay.getMonthValue() > today.getMonthValue()) {
            bw.write("gg");
            return;
        }

        if (dDay.getDayOfMonth() < today.getDayOfMonth()) {
            bw.write("D-" + dayDiff);
            return;
        }

        bw.write("gg");
    }
}