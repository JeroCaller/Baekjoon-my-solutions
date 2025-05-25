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
        final int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int numOfPrimes = 0;
        final boolean[] isNotPrimeArray = getIsNotPrimeArray(findMaxNumber(numbers));
        for (int number : numbers) {
            if (!isNotPrimeArray[number]) {
                ++numOfPrimes;
            }
        }

        bw.write(String.valueOf(numOfPrimes));
    }

    public static int findMaxNumber(int[] numbers) {
        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            if (maxNumber < numbers[i]) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public static boolean[] getIsNotPrimeArray(int n) {
        // 소수면 false, 아니면 true
        // 처음에는 모두 false로 초기화.
        // 즉, 처음에는 모든 수가 소수라 가정한 다음, 나중에 하나씩 검증하면서
        // 소수가 아닌 요소에만 true 체크를 하는 방식.
        boolean[] isNotPrimeArray = new boolean[n + 1];
        isNotPrimeArray[0] = true;
        isNotPrimeArray[1] = true;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            // 값이 true라는 것은 이미 해당 값을 검증한 것이므로 패스.
            if (isNotPrimeArray[i]) {
                continue;
            }

            // i의 배수들은 모두 소수가 아니므로 거른다.
            for (int j = i * i; j < isNotPrimeArray.length; j = j + i) {
                isNotPrimeArray[j] = true;
            }
        }

        return isNotPrimeArray;
    }

}