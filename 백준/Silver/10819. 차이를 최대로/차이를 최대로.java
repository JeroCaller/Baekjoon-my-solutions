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

    private static int n;
    private static int[] array;
    private static final List<List<Integer>> allResults = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        processInput();
        generateAllCases(new ArrayList<>());
        int answer = getMax();
        bw.write(String.valueOf(answer));
    }

    private static void processInput() throws IOException {
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void generateAllCases(List<Integer> oneList) {
        if (oneList.size() == n) {
            allResults.add(new ArrayList<>(oneList));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            oneList.add(array[i]);
            visited[i] = true;
            generateAllCases(oneList);
            oneList.remove(oneList.size() - 1);
            visited[i] = false;
        }
    }

    private static int getMax() {
        int maximum = 0;

        for (List<Integer> oneList : allResults) {
            int total = 0;

            for (int i = 0; i < oneList.size() - 1; ++i) {
                total += Math.abs(oneList.get(i) - oneList.get(i + 1));
            }

            maximum = Math.max(maximum, total);
        }

        return maximum;
    }
}
