import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static final List<Ingredient> ingredients = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String[] inputs = br.readLine().split(" ");
            ingredients.add(new Ingredient(
                Integer.parseInt(inputs[0]),
                Integer.parseInt(inputs[1])
            ));
        }

        findAnswer(new ArrayList<>(), 0);
        bw.write(String.valueOf(answer));
    }

    private static void findAnswer(List<Ingredient> list, int startIdx) {
        if (!list.isEmpty()) {
            int totalS = 1, totalB = 0;

            for (Ingredient ingredient : list) {
                totalS *= ingredient.getS();
                totalB += ingredient.getB();
            }

            answer = Math.min(answer, Math.abs(totalS - totalB));
        }

        for (int i = startIdx; i < n; ++i) {
            list.add(ingredients.get(i));
            findAnswer(list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

class Ingredient {
    private int s;
    private int b;

    public Ingredient(int s, int b) {
        this.s = s;
        this.b = b;
    }

    public int getS() { return s; }
    public int getB() { return b; }
}