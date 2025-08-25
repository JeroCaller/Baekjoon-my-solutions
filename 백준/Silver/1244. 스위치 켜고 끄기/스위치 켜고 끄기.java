import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        final int S = Integer.parseInt(br.readLine());
        boolean[] switchesStatus = new boolean[S + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < switchesStatus.length; ++i) {
            int statusInNum = Integer.parseInt(stringTokenizer.nextToken());
            switchesStatus[i] = statusInNum == 1;
        }

        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String[] studentInputs = br.readLine().split(" ");
            final int GENDER_NUM = Integer.parseInt(studentInputs[0]);
            final int SWITCH_NUM = Integer.parseInt(studentInputs[1]);

            switch (GENDER_NUM) {
                case 1:
                    for (int j = SWITCH_NUM; j < switchesStatus.length; j += SWITCH_NUM) {
                        switchesStatus[j] = !switchesStatus[j];
                    }
                    break;
                case 2:
                    int leftIdx = SWITCH_NUM;
                    int rightIdx = SWITCH_NUM;

                    while (leftIdx > 1 && rightIdx < switchesStatus.length - 1) {
                        if (switchesStatus[leftIdx] == switchesStatus[rightIdx]) {
                            --leftIdx;
                            ++rightIdx;
                        } else {
                            break;
                        }
                    }

                    if (switchesStatus[leftIdx] != switchesStatus[rightIdx]) {
                        ++leftIdx;
                        --rightIdx;
                    }

                    for (int j = leftIdx; j <= rightIdx; ++j) {
                        switchesStatus[j] = !switchesStatus[j];
                    }

                    break;
            }

            //bw.write(Arrays.toString(boolToInt(switchesStatus)));
            //bw.newLine();
        }

        for (int i = 1; i < switchesStatus.length; ++i) {
            if (i != 1 && i % 20 == 1) {
                bw.newLine();
            }

            String answer = switchesStatus[i] ? "1" : "0";
            bw.write(answer + " ");
        }
    }

    private static int[] boolToInt(boolean[] bools) {
        int[] numArr = new int[bools.length];

        for (int i = 0; i < bools.length; ++i) {
            numArr[i] = bools[i] ? 1 : 0;
        }

        return numArr;
    }
}
