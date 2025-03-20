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

        int n = Integer.parseInt(br.readLine());
        int result = sum(n);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int sum(int n) {
        return (n * (n + 1)) / 2;
    }

}
