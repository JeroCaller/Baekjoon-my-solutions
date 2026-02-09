import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

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
        String data = br.readLine();
        Stack<Character> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < data.length(); ++i) {
            char currentChar = data.charAt(i);

            if (currentChar == '(') {
                stack.push(currentChar);
            } else {
                stack.pop();

                if (i > 0 && data.charAt(i - 1) == ')') {
                    total++;
                } else {
                    total += stack.size();
                }
            }
        }

        bw.write(String.valueOf(total));
    }
}
