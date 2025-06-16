import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

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
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        // sum, count
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 1; i <= nums[0]; ++i) {
            for (int j = 1; j <= nums[1]; ++j) {
                for (int k = 1; k <= nums[2]; ++k) {
                    int sum = i + j + k;
                    if (counter.containsKey(sum)) {
                        counter.put(sum, counter.get(sum) + 1);
                    } else {
                        counter.put(sum, 1);
                    }
                }
            }
        }

        Map.Entry<Integer, Integer> freqEntry = null;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (freqEntry == null) {
                freqEntry = entry;
                continue;
            }
            if ((freqEntry.getValue() < entry.getValue()) ||
                ((freqEntry.getValue().equals(entry.getValue())) &&
                    (freqEntry.getKey() > entry.getKey())
                )) {
                freqEntry = entry;
            }
        }
        bw.write(String.valueOf(freqEntry.getKey()));
    }
}