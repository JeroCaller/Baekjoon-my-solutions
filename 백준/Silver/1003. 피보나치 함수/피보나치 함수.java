import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<Integer> fiboList = new ArrayList<>(Arrays.asList(0, 1));
    private static final List<ZeroOne> zeroOneCountList = new ArrayList<>();
    private static int zeroOneListIndex = 0;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        zeroOneCountList.add(new ZeroOne(1, 0));
        zeroOneCountList.add(new ZeroOne(0, 1));

        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            fibonacci(Integer.parseInt(br.readLine()));
            ZeroOne zeroOne = zeroOneCountList.get(zeroOneListIndex);
            bw.write(zeroOne.getNumOfZero() + " " + zeroOne.getNumOfOne());
            bw.newLine();
        }
    }

    private static int fibonacci(int n) {
        if (n < fiboList.size()) {
            zeroOneListIndex = n;
            return fiboList.get(n);
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);

        zeroOneListIndex = n;
        if (n >= zeroOneCountList.size()) {
            zeroOneCountList.add(ZeroOne.getAddedInstance(
                zeroOneCountList.get(n - 1),
                zeroOneCountList.get(n - 2)
            ));
        }

        fiboList.add(result);

        return result;
    }
}

class ZeroOne {

    private int numOfZero;
    private int numOfOne;

    public ZeroOne(int numOfZero, int numOfOne) {
        this.numOfZero = numOfZero;
        this.numOfOne = numOfOne;
    }

    public int getNumOfZero() {
        return numOfZero;
    }

    public int getNumOfOne() {
        return numOfOne;
    }

    public static ZeroOne getAddedInstance(ZeroOne first, ZeroOne second) {
        return new ZeroOne(
            first.getNumOfZero() + second.getNumOfZero(),
            first.getNumOfOne() + second.getNumOfOne()
        );
    }
}