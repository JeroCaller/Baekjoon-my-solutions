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

        int bul = Integer.parseInt(br.readLine());
        int result = bul - 543;
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
