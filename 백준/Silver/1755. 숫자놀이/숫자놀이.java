import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        String[] inputs = br.readLine().split(" ");
        final int M = Integer.parseInt(inputs[0]);
        final int N = Integer.parseInt(inputs[1]);

        final Map<Character, String> numToStrMap = new HashMap<>();
        numToStrMap.put('1', "one");
        numToStrMap.put('2', "two");
        numToStrMap.put('3', "three");
        numToStrMap.put('4', "four");
        numToStrMap.put('5', "five");
        numToStrMap.put('6', "six");
        numToStrMap.put('7', "seven");
        numToStrMap.put('8', "eight");
        numToStrMap.put('9', "nine");
        numToStrMap.put('0', "zero");

        final List<Data> list = new LinkedList<>();
        Data data = null;

        for (int i = M; i <= N; ++i) {
            data = new Data();
            data.setNumber(i, numToStrMap);
            list.add(data);
        }

        list.sort((d1, d2) -> {
            int firstCompareResult = d1.getNumInEng()[0].compareTo(d2.getNumInEng()[0]);

            if (firstCompareResult != 0 ||
                (d1.getNumInEng()[1] == null || d2.getNumInEng()[1] == null)
            ) {
                return firstCompareResult;
            }

            return d1.getNumInEng()[1].compareTo(d2.getNumInEng()[1]);
        });

        for (int i = 0; i < list.size(); ++i) {
            if (i != 0 && i % 10 == 0) {
                bw.newLine();
            }

            bw.write(list.get(i).getNumber() + " ");
        }
    }
}

class Data {

    private int number;
    private final String[] numInEng = new String[2];

    public void setNumber(int number, Map<Character, String> map) {
        this.number = number;
        String numInStr = String.valueOf(number);

        for (int i = 0; i < numInStr.length(); ++i) {
            numInEng[i] = map.get(numInStr.charAt(i));
        }
    }

    public int getNumber() {
        return number;
    }

    public String[] getNumInEng() {
        return numInEng;
    }
}
