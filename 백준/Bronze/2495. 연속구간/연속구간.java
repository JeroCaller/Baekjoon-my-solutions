import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        final int T = 3;
        final Pair<Character, Integer> answer = new Pair<>();
        final Pair<Character, Integer> current = new Pair<>();

        for (int i = 0; i < T; ++i) {
            String source = br.readLine();

            boolean isCurrentComparedToAnswer = false;
            answer.setKey(source.charAt(0));
            answer.setValue(1);
            current.setKey(source.charAt(0));
            current.setValue(1);
            for (int j = 1; j < source.length(); ++j) {
                char currentChar = source.charAt(j);
                if (currentChar == current.getKey()) {
                    current.setValue(current.getValue() + 1);
                    isCurrentComparedToAnswer = false;
                } else {
                    compareAndSetAnswer(answer, current);
                    current.setKey(currentChar);
                    current.setValue(1);
                    isCurrentComparedToAnswer = true;
                }
            }
            if (!isCurrentComparedToAnswer) {
                compareAndSetAnswer(answer, current);
            }

            bw.write(String.valueOf(answer.getValue()));
            bw.newLine();
        }
    }

    static void compareAndSetAnswer(
        Pair<Character, Integer> answer,
        Pair<Character, Integer> current
    ) {
        if (answer.getValue() < current.getValue()) {
            answer.setKey(current.getKey());
            answer.setValue(current.getValue());
        }
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair() {}

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}