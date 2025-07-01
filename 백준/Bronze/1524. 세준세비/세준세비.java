import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

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
        final int T = Integer.parseInt(br.readLine());
        Stack<Integer> junPowers = null;
        Stack<Integer> biPowers = null;

        for (int i = 0; i < T; ++i) {
            br.readLine();

            String[] nm = br.readLine().split(" ");
            final int N = Integer.parseInt(nm[0]);
            final int M = Integer.parseInt(nm[1]);

            junPowers = getSortedStackFromParsing(br.readLine());
            biPowers = getSortedStackFromParsing(br.readLine());

            while (!junPowers.isEmpty() && !biPowers.isEmpty()) {
                if (junPowers.peek() >= biPowers.peek()) {
                    biPowers.pop();
                } else {
                    junPowers.pop();
                }
            }

            if (!junPowers.isEmpty() && biPowers.isEmpty()) {
                bw.write("S");
            } else if (junPowers.isEmpty() && !biPowers.isEmpty()) {
                bw.write("B");
            } else {
                bw.write("C");
            }
            bw.newLine();
        }
    }

    public static Stack<Integer> getSortedStackFromParsing(String numbers) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer stringTokenizer = new StringTokenizer(numbers, " ");

        while (stringTokenizer.hasMoreTokens()) {
            stack.push(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stack.sort((a, b) -> b - a);
        return stack;
    }
}