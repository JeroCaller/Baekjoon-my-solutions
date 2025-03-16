import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        String oneLine = null;
        for (int i = 1; i <= 9; i++) {
            oneLine = String.format("%d * %d = %d", N, i, N * i);
            stringBuilder.append(oneLine);
            if (i != 9) {
                stringBuilder.append("\n");
            }
        }

        bw.write(stringBuilder.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
