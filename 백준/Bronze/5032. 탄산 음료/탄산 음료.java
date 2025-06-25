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
        String[] input = br.readLine().split(" ");
        int leftBottles = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        int required = Integer.parseInt(input[2]);
        int answer = 0;

        while (leftBottles >= required) {
            int q = leftBottles / required;
            int r = leftBottles % required;
            answer += q;
            leftBottles = q + r;
        }
        bw.write(String.valueOf(answer));
    }
}