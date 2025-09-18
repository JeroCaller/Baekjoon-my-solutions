import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//@Slf4j
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
        final int T = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;
        int[] coords = new int[6];

        for (int i = 0; i < T; ++i) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < coords.length; ++j) {
                coords[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // distance between centers of circles
            double d = Math.sqrt(
                Math.pow(coords[0] - coords[3], 2) + Math.pow(coords[1] - coords[4], 2)
            );
            double rTotal = coords[2] + coords[5];
            double diff = d - rTotal;
            int answer;

            if (d == 0) {
                if (coords[2] == coords[5]) {
                    answer = -1;
                } else {
                    answer = 0;
                }
            } else if (diff > 0) {
                answer = 0;
            } else if (diff < 0) {
                double innerDiff = (d + Math.min(coords[2], coords[5])) -
                    Math.max(coords[2], coords[5]);

                if (innerDiff < 0) {
                    // circle in the circle
                    answer = 0;
                } else if (innerDiff == 0) {
                    // circle in the circle
                    answer = 1;
                } else {
                    answer = 2;
                }
            } else {
                answer = 1;
            }

            bw.write(String.valueOf(answer));
            bw.newLine();

            //log.info("d: {}, rTotal: {}, diff: {}, answer: {}", d, rTotal, diff, answer);
        }
    }
}
