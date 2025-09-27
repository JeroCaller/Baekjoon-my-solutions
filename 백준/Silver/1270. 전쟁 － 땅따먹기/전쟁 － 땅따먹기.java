import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
        final Map<Long, Integer> soldiersMap = new HashMap<>();
        int t;

        for (int i = 0; i < N; ++i) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            t = Integer.parseInt(stringTokenizer.nextToken());

            while (stringTokenizer.hasMoreTokens()) {
                long toNumber = Long.parseLong(stringTokenizer.nextToken());

                if (!soldiersMap.containsKey(toNumber)) {
                    soldiersMap.put(toNumber, 1);
                } else {
                    soldiersMap.put(toNumber, soldiersMap.get(toNumber) + 1);
                }
            }

            Map.Entry<Long, Integer> maxSoldierEntry = null;

            for (Map.Entry<Long, Integer> entry : soldiersMap.entrySet()) {
                if (maxSoldierEntry == null || maxSoldierEntry.getValue() < entry.getValue()) {
                    maxSoldierEntry = entry;
                }
            }

            if (maxSoldierEntry.getValue() <= t / 2) {
                bw.write("SYJKGW");
            } else {
                bw.write(String.valueOf(maxSoldierEntry.getKey()));
            }

            bw.newLine();
            soldiersMap.clear();
        }
    }
}
