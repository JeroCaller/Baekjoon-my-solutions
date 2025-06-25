import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {

    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final Stack<Character> reversedStack = new Stack<>();
    private static final ArrayDeque<Character> palindromeQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            String numberStr = br.readLine();
            int number = Integer.parseInt(numberStr);
            int reversedNum = getReversedNumber(numberStr);
            if (isPalindrome(number + reversedNum)) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }
    }

    public static int getReversedNumber(String source) {
        reversedStack.clear();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < source.length(); ++i) {
            reversedStack.push(source.charAt(i));
        }

        while (!reversedStack.isEmpty()) {
            stringBuilder.append(reversedStack.pop());
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static boolean isPalindrome(int number) {
        palindromeQueue.clear();
        String numStr = String.valueOf(number);

        for (int i = 0; i < numStr.length(); ++i) {
            palindromeQueue.offer(numStr.charAt(i));
        }

        while (!palindromeQueue.isEmpty()) {
            Character left = palindromeQueue.pollFirst();
            Character right = palindromeQueue.pollLast();
            if (right == null) {
                return true;
            }
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }
}