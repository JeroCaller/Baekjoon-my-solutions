import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int[] weights = new int[3];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        int result = Arrays.stream(weights).sorted().toArray()[1];
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
