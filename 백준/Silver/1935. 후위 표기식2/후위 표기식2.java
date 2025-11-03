import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
        final int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        final Map<Character, Double> alphabetToIntMap = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            alphabetToIntMap.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }

        final Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char currentChar = expression.charAt(i);

            if (alphabetToIntMap.containsKey(currentChar)) {
                stack.push(alphabetToIntMap.get(currentChar));
            } else {
                double rightNum = stack.pop();
                double leftNum = stack.pop();
                stack.push(getResult(leftNum, rightNum, currentChar));
            }
        }

        bw.write(String.format("%.2f", stack.peek()));
    }

    private static Double getResult(double leftNum, double rightNum, char operator) {
        switch (operator) {
            case '+':
                return leftNum + rightNum;
            case '-':
                return  leftNum - rightNum;
            case '*':
                return  leftNum * rightNum;
            case '/':
                return  leftNum / rightNum;
            default:
                return null;
        }
    }
}

