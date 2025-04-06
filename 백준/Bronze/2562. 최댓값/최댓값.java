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
        List<Integer> nums = getIntList(9);
        Result result = getMaxResult(nums);
        bw.write(result.toString());
    }

    public static List<Integer> getIntList(int N) throws IOException {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        return nums;
    }

    public static Result getMaxResult(List<Integer> nums) {
        Result result = new Result();
        result.setMaxNum(nums.get(0));
        result.setMaxIndex(0);

        for (int i = 1; i < nums.size(); ++i) {
            int currentNum = nums.get(i);
            if (result.getMaxNum() < currentNum) {
                result.setMaxIndex(i);
                result.setMaxNum(currentNum);
            }
        }

        return result;
    }

}

class Result {

    private int maxNum;
    private int maxIndex;

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex + 1;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    @Override
    public String toString() {
        return maxNum + "\n" + maxIndex;
    }

}
