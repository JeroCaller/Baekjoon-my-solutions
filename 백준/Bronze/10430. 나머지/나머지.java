import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(source);
        int[] numbers = new int[3];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }

        int[] results = {
            first(numbers),
            second(numbers),
            third(numbers),
            fourth(numbers)
        };

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < results.length; j++) {
            stringBuilder.append(results[j]);
            if (j != results.length - 1) {
                stringBuilder.append("\n");
            }
        }

        bw.write(stringBuilder.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static int first(int[] numbers) {
        return (numbers[0] + numbers[1]) % numbers[2];
    }

    public static int second(int[] numbers) {
        return ((numbers[0] % numbers[2]) + (numbers[1] % numbers[2])) % numbers[2];
    }

    public static int third(int[] numbers) {
        return (numbers[0] * numbers[1]) % numbers[2];
    }

    public static int fourth(int[] numbers) {
        return ((numbers[0] % numbers[2]) * (numbers[1] % numbers[2])) % numbers[2];
    }

}
