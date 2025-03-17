import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

        String[] meow = {
            "\\    /\\",
            " )  ( ')",
            "(  /  )",
            " \\(__)|",
        };

        for (int i = 0; i < meow.length; i++) {
            bw.write(meow[i]);
            if (i != meow.length - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

}
