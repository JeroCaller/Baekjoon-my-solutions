import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int result = 0;

        if (x * y > 0) {
            result = (x > 0) ? 1 : 3;
        } else {
            result = (x > 0) ? 4 : 2;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
