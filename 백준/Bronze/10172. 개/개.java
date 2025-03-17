import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bowWow = {
            "|\\_/|",
            "|q p|   /}",
            "( 0 )\"\"\"\\",
            "|\"^\"`    |",
            "||_/=\\\\__|"
        };

        for (int i = 0; i < bowWow.length; i++) {
            bw.write(bowWow[i]);
            if (i != bowWow.length - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();

    }

}
