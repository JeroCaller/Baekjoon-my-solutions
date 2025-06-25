import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

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
        int maxPrice = 0;

        // number, counter
        Map<Integer, Integer> dice = new TreeMap<>();
        Stack<Integer> pairNum = new Stack<>();

        for (int i = 0; i < N; ++i) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; ++j) {
                int num = Integer.parseInt(input[j]);
                if (dice.containsKey(num)) {
                    dice.put(num, dice.get(num) + 1);
                } else {
                    dice.put(num, 1);
                }
            }

            int price = 0;
            for (Map.Entry<Integer, Integer> entry : dice.entrySet()) {
                if (entry.getValue().equals(4)) {
                    price = 50000 + entry.getKey() * 5000;
                    break;
                }
                if (entry.getValue().equals(3)) {
                    price = 10000 + entry.getKey() * 1000;
                    break;
                }

                if (entry.getValue().equals(2)) {
                    pairNum.push(entry.getKey());
                }
            }
            if (pairNum.size() == 2) {
                price = 2000 + pairNum.pop() * 500 + pairNum.pop() * 500;
            } else if (pairNum.size() == 1) {
                price = 1000 + pairNum.pop() * 100;
            } else if (price == 0) {
                int maxN = dice.keySet().stream().max((a, b) -> a - b).get();
                price = maxN * 100;
            }

            if (maxPrice < price) {
                maxPrice = price;
            }

            dice.clear();
        }

        bw.write(String.valueOf(maxPrice));
    }
}