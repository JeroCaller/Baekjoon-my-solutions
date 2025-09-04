import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

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
        final String INVALID = "Invalid";
        final String VALID = "Valid";

        String input = null;
        Deque<String> deque = new LinkedList<>();

        while (true) {
            input = br.readLine();

            if (input == null || input.isEmpty()) {
                break;
            }

            if (deque.isEmpty()) {
                deque.offer(input);
                continue;
            }

            if (isNotKnightPath(deque.peekLast(), input) || deque.contains(input)) {
                bw.write(INVALID);
                return;
            }

            deque.offer(input);
        }

        if (isNotKnightPath(deque.peek(), deque.peekLast()) || deque.contains(input)) {
            bw.write(INVALID);
        } else {
            bw.write(VALID);
        }
    }

    private static boolean isNotKnightPath(String before, String current) {
        int alphabetDiff = Math.abs(current.charAt(0) - before.charAt(0));
        int numberDiff = Math.abs(current.charAt(1) - before.charAt(1));

        return !((alphabetDiff == 2 && numberDiff == 1) || (alphabetDiff == 1 && numberDiff == 2));
    }
}
