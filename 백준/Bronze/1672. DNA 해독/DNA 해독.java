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
        String series = br.readLine();

        Map<Character, Integer> charToIntMap = new HashMap<>();
        charToIntMap.put('A', 0);
        charToIntMap.put('G', 1);
        charToIntMap.put('C', 2);
        charToIntMap.put('T', 3);

        char[][] table = {
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'},
        };

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < series.length(); ++i) {
            stack.push(series.charAt(i));
        }

        while (stack.size() > 1) {
            int c = charToIntMap.get(stack.pop());
            int r = charToIntMap.get(stack.pop());
            stack.push(table[r][c]);
        }

        bw.write(stack.firstElement());
    }
}