import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> dices = getDicesMap(br.readLine());
        int price = getPrice(dices);

        bw.write(String.valueOf(price));

        bw.flush();
        bw.close();
        br.close();
    }

    public static Map<Integer, Integer> getDicesMap(String source) {
        Map<Integer, Integer> dices = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(source);

        stringTokenizer.asIterator().forEachRemaining(token -> {
            int dice = Integer.parseInt((String) token);
            if (dices.containsKey(dice)) {
                dices.replace(dice, dices.get(dice) + 1);
            } else {
                dices.put(dice, 1);
            }
        });

        return dices;
    }

    public static int getPrice(Map<Integer, Integer> dices) {
        int maxKey = 0;
        int price = 0;

        origin: for (Map.Entry<Integer, Integer> oneDice : dices.entrySet()) {
            switch (oneDice.getValue()) {
                case 3:
                    price = 10000 + (oneDice.getKey() * 1000);
                    break origin;
                case 2:
                    price = 1000 + (oneDice.getKey() * 100);
                    break origin;
                case 1:
                    maxKey = (maxKey < oneDice.getKey()) ? oneDice.getKey() :
                        maxKey;
                    break;
            }
        }
        if (price == 0) {
            price = maxKey * 100;
        }

        return price;
    }

}
