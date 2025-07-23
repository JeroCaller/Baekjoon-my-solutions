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
        final int N = Integer.parseInt(br.readLine());
        String[] room = new String[N];

        for (int i = 0; i < N; ++i) {
            room[i] = br.readLine();
        }

        int horizon = getCount(room, "H");
        int vertical = getCount(room, "V");

        bw.write(String.format("%d %d", horizon, vertical));
    }

    private static int getCount(String[] room, String direction) {
        final int N = room.length;

        int count = 0;
        for (int i = 0; i < N; ++i) {
            int start = 0;
            int end = 1;

            while (start < N && end < N) {
                char startChar;
                char endChar;

                if (direction.equals("H")) {
                    startChar = room[i].charAt(start);
                    endChar = room[i].charAt(end);
                } else {
                    startChar = room[start].charAt(i);
                    endChar = room[end].charAt(i);
                }

                if (startChar == 'X') {
                    ++start;
                    end = start + 1;
                    continue;
                }

                if (endChar == 'X') {
                    if (end - 1 - start >= 1) {
                        ++count;
                    }
                    start = end + 1;
                    end = start + 1;
                } else {
                    ++end;
                }
            }

            if (start < N - 1 && end - 1 - start >= 1) {
                ++count;
            }
        }

        return count;
    }
}
