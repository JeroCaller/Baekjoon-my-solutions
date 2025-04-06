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
        int total = 30;
        int N = 28;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < total; ++i) {
            nums.add(i + 1);
        }

        for (int j = 0; j < N; ++j) {
            int currentNum = Integer.parseInt(br.readLine());
            nums.remove(Integer.valueOf(currentNum));
        }

        String result = nums.get(0) + "\n" + nums.get(1);
        bw.write(result);
    }

}
