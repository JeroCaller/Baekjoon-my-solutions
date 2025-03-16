import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stringBuilder.append("*".repeat(i));
            if (i != N) {
                stringBuilder.append("\n");
            }
        }

        bw.write(stringBuilder.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
