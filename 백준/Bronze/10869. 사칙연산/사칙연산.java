import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();

        // 문자열로부터 두 숫자 추출
        StringTokenizer stringTokenizer = new StringTokenizer(source);
        int[] numbers = new int[2];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }

        // 사칙연산 결과 도출 및 저장.
        int[] results = {
            add(numbers),
            subtract(numbers),
            multiply(numbers),
            divQ(numbers),
            divR(numbers)
        };

        // 결과 출력
        for (int j = 0; j < results.length; j++) {
            bw.write(String.valueOf(results[j]));
            if (j != results.length - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static int add(int[] nums) {
        return nums[0] + nums[1];
    }

    public static int subtract(int[] nums) {
        return nums[0] - nums[1];
    }

    public static int multiply(int[] nums) {
        return nums[0] * nums[1];
    }

    public static int divQ(int[] nums) {
        return nums[0] / nums[1];
    }

    public static int divR(int[] nums) {
        return nums[0] % nums[1];
    }

}