import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();
        String[] tokens = source.split(" ");
        int[] numbers = new int[2];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        String result = null;
        int diff = numbers[0] - numbers[1];
        if (diff > 0) {
            result = ">";
        } else if (diff < 0) {
            result = "<";
        } else {
            result = "==";
        }

        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }

}