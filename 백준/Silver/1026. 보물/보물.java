import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
        final int N = Integer.parseInt(br.readLine());
        List<Integer> listA = initializeArray(br.readLine());
        List<Integer> listB = initializeArray(br.readLine());
        int total = 0;

        while (!listA.isEmpty() && !listB.isEmpty()) {
            int aIdx = 0;
            int bIdx = 0;

            for (int i = 0; i < listA.size(); ++i) {
                if (listA.get(i) < listA.get(aIdx)) {
                    aIdx = i;
                }

                if (listB.get(i) > listB.get(bIdx)) {
                    bIdx = i;
                }
            }

            total += listA.remove(aIdx) * listB.remove(bIdx);
        }

        bw.write(String.valueOf(total));
    }

    private static List<Integer> initializeArray(String source) {
        StringTokenizer stringTokenizer = new StringTokenizer(source, " ");
        List<Integer> list = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return list;
    }
}
