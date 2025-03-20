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

        String[] input = br.readLine().split(" ");

        int[] original = {1, 1, 2, 2, 2, 8};
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            stringBuilder.append(original[i] - num).append(" ");
        }

        bw.write(stringBuilder.toString().trim());

        bw.flush();
        bw.close();
        br.close();
    }

}
