import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        final int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int total = 0;
        Integer maxNum = null;
        Integer minNum = null;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            int currentNum = Integer.parseInt(br.readLine());
            nums[i] = currentNum;
            total += currentNum;

            if (maxNum == null || maxNum < currentNum) {
                maxNum = currentNum;
            }

            if (minNum == null || minNum > currentNum) {
                minNum = currentNum;
            }

            if (freqMap.containsKey(currentNum)) {
                freqMap.put(currentNum, freqMap.get(currentNum) + 1);
            } else {
                freqMap.put(currentNum, 1);
            }
        }

        Arrays.sort(nums);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> {
            int valueDiff = e2.getValue() - e1.getValue();

            if (valueDiff != 0) {
                return valueDiff;
            }

            return e1.getKey() - e2.getKey();
        });

        bw.write(String.valueOf(Math.round((float) total / N)));
        bw.newLine();
        bw.write(String.valueOf(nums[N / 2]));
        bw.newLine();

        if (entryList.size() == 1) {
            bw.write(String.valueOf(entryList.get(0).getKey()));
        } else if (entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
            bw.write(String.valueOf(entryList.get(1).getKey()));
        } else {
            bw.write(String.valueOf(entryList.get(0).getKey()));
        }

        bw.newLine();
        bw.write(String.valueOf(maxNum - minNum));
    }
}
