import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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
        List<Integer> sortedNums = new ArrayList<>();
        Set<Integer> insertedNumsSet = new HashSet<>();

        for (int i = 0; i < N; ++i) {
            int currentNums = Integer.parseInt(st.nextToken());
            nums[i] = currentNums;

            if (!insertedNumsSet.contains(currentNums)) {
                sortedNums.add(currentNums);
                insertedNumsSet.add(currentNums);
            }
        }

        Collections.sort(sortedNums);

        for (int i = 0; i < N; ++i) {
            int xPrime = binarySearch(sortedNums, nums[i]);
            bw.write(xPrime + " ");
        }
    }

    private static int binarySearch(List<Integer> list, int targetValue) {
        long leftIdx = 0;
        long rightIdx = list.size() - 1;
        long midIdx = (leftIdx + rightIdx) / 2;

        while (leftIdx <= rightIdx) {
            if (list.get((int) midIdx).equals(targetValue)) {
                return (int) midIdx;
            }

            if (list.get((int) midIdx) < targetValue) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }

            midIdx = (leftIdx + rightIdx) / 2;
        }

        return -1;
    }
}

