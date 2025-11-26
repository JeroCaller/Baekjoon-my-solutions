import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        final int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; ++i) {
            String[] nm = br.readLine().split(" ");
            final int N = Integer.parseInt(nm[0]);
            final int M = Integer.parseInt(nm[1]);
            int[] arrayA = toArray(new StringTokenizer(br.readLine(), " "));
            int[] arrayB = toArray(new StringTokenizer(br.readLine(), " "));
            int count = 0;

            Arrays.sort(arrayA);
            Arrays.sort(arrayB);
            
            for (int targetNumber : arrayA) {
                int leftIdx = 0;
                int rightIdx = arrayB.length - 1;
                int midIdx = (leftIdx + rightIdx) / 2;

                while (leftIdx < rightIdx) {
                    if (arrayB[midIdx] >= targetNumber) {
                        rightIdx = midIdx;
                    } else {
                        leftIdx = midIdx + 1;
                    }

                    midIdx = (leftIdx + rightIdx) / 2;
                }

                if (arrayB[midIdx] >= targetNumber) {
                    count += midIdx;
                } else {
                    count += midIdx + 1;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }
    
    private static int[] toArray(StringTokenizer stringTokenizer) {
        int[] array = new int[stringTokenizer.countTokens()];
        
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        return array;
    }
}
