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

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String source = br.readLine();
            if (source == null || source.isBlank()) break;

            String[] oneLine = source.split(" ");

            int a = Integer.parseInt(oneLine[0]);
            int b =  Integer.parseInt(oneLine[1]);
            stringBuilder.append(a + b)
                .append("\n");
        }

        bw.write(stringBuilder.toString().trim());

        bw.flush();
        bw.close();
        br.close();
    }

}
