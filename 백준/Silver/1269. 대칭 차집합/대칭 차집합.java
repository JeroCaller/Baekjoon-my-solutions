import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
        String[] firstLine = br.readLine().split(" ");
        final int A = Integer.parseInt(firstLine[0]);
        final int B = Integer.parseInt(firstLine[1]);

        Set<Integer> setA = getSetFromInput(br.readLine());
        Set<Integer> setB = getSetFromInput(br.readLine());
        Set<Integer> union = new HashSet<>(setA);
        Set<Integer> intersection = new HashSet<>(setA);

        union.addAll(setB);
        intersection.retainAll(setB);

        bw.write(String.valueOf(union.size() - intersection.size()));

        /*
        bw.newLine();
        bw.write("A: " + setA.toString());
        bw.newLine();
        bw.write("B: " + setB.toString());
        bw.newLine();
        bw.write("union: " + union.toString());
        bw.newLine();
        bw.write("intersection: " + intersection.toString());
        */
    }

    private static Set<Integer> getSetFromInput(String input) {
        Set<Integer> set = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");

        while (stringTokenizer.hasMoreTokens()) {
            set.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return set;
    }
}
