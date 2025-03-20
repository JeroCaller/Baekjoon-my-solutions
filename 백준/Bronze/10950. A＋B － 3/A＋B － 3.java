import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int testCasesNum = Integer.parseInt(br.readLine());
        int[][] allNums = new int[testCasesNum][2];
        String oneLine;
        String[] numsStr;
        for (int i = 0; i < testCasesNum; i++) {
            oneLine = br.readLine();
            numsStr = oneLine.split(" ");
            for (int j = 0; j < 2; j++) {
                allNums[i][j] = Integer.parseInt(numsStr[j]);
            }
        }

        for (int k = 0; k < testCasesNum; k++) {
            int result = 0;
            for (int l = 0; l < 2; l++) {
                result += allNums[k][l];
            }
            bw.write(String.valueOf(result));
            if (k != testCasesNum - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}