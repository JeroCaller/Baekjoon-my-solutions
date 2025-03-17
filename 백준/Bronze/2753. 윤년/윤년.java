import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static String mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        String result = process(year);
        bw.write(result);

        bw.flush();
        bw.close();
        br.close();

        return result;
    }

    public static String process(int input) {
        String result;
        if (conditionA(input) || conditionB(input)) {
            result = "1";
        } else {
            result = "0";
        }
        return result;
    }

    public static boolean conditionA(int year) {
        return isMultiple(year, 4) && !isMultiple(year, 100);
    }

    public static boolean conditionB(int year) {
        return isMultiple(year, 400);
    }

    public static boolean isMultiple(int target, int number) {
        return target % number == 0;
    }

}
