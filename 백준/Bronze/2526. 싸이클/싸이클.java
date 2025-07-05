import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int P = Integer.parseInt(inputs[1]);
        List<Integer> nodes = new ArrayList<>();

        int currentNum = N;
        while (!nodes.contains(currentNum)) {
            nodes.add(currentNum);
            currentNum = (currentNum * N) % P;
        }

        int answer = nodes.size() - nodes.indexOf(currentNum);
        bw.write(String.valueOf(answer));
    }
}