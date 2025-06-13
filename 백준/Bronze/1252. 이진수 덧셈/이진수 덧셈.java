import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
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
        String[] input = br.readLine().split(" ");
        Stack<Integer> aStack = getInitializedStack(input[0]);
        Stack<Integer> bStack = getInitializedStack(input[1]);
        Stack<Integer> stack = new Stack<>();

        // calculate
        int carry = 0;
        while (!aStack.isEmpty() || !bStack.isEmpty()) {
            int aBit = 0;
            int bBit = 0;
            try {
                aBit = aStack.pop();
            } catch (EmptyStackException e) {}

            try {
                bBit = bStack.pop();
            } catch (EmptyStackException e) {}

            int sum = aBit + bBit + carry;
            stack.push(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            stack.push(carry);
        }

        // zero check
        while (!stack.isEmpty()) {
            if (stack.peek() == 0) {
                stack.pop();
            } else {
                break;
            }
        }
        if (stack.isEmpty()) {
            bw.write(String.valueOf(0));
            return;
        }

        // print
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        bw.write(stringBuilder.toString());
    }

    public static Stack<Integer> getInitializedStack(String source) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < source.length(); ++i) {
            stack.push(source.charAt(i) - '0');
        }
        return stack;
    }
}