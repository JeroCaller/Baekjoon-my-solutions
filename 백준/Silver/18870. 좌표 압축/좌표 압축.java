import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        Set<Integer> numsSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>(); // X : index

        for (int i = 0; i < N; ++i) {
            int currentNum = Integer.parseInt(st.nextToken());
            nums[i] = currentNum;
            numsSet.add(currentNum);
        }

        int index = 0;

        for (int num : numsSet) {
            map.put(num, index++);
        }

        for (int i = 0; i < N; ++i) {
            int xPrime = map.get(nums[i]);
            bw.write(xPrime + " ");
        }
    }
}

