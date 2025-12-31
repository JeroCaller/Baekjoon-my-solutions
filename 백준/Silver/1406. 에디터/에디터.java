import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        StringBuilder sb = new StringBuilder(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        int cursor = sb.length();  // 0 <= cursor <= length

        for (int i = 0; i < M; ++i) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (cursor > 0) {
                        --cursor;
                    }

                    break;
                case 'D':
                    if (cursor < sb.length()) {
                        ++cursor;
                    }

                    break;
                case 'B':
                    if (cursor > 0) {
                        sb.deleteCharAt(cursor - 1);
                        --cursor;
                    }

                    break;
                case 'P':
                    char charToInsert = command.charAt(command.length() - 1);

                    if (cursor == sb.length()) {
                        sb.append(charToInsert);
                    } else {
                        sb.insert(cursor, charToInsert);
                    }

                    if (cursor < sb.length()) {
                        ++cursor;
                    }

                    break;
            }
        }

        bw.write(sb.toString());
    }
}
