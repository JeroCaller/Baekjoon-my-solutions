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

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static int pointerIndex = 0;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final String KBS_ONE = "KBS1";
        final String KBS_TWO = "KBS2";

        final int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];

        for (int i = 0;  i < N; ++i) {
            channels[i] = br.readLine();
        }

        while (!channels[0].equals(KBS_ONE)) {
            executeLoop(channels, KBS_ONE);
        }

        while (!channels[1].equals(KBS_TWO)) {
            executeLoop(channels, KBS_TWO);
        }

        bw.write(stringBuilder.toString());
    }

    private static void executeLoop(String[] channels, String target) {
        if (!channels[pointerIndex].equals(target)) {
            getPointerDown(channels.length);
        } else {
            getCurrentChannelUp(channels);
        }
    }

    public static void getPointerDown(int limitSize) {
        if (pointerIndex + 1 < limitSize) {
            ++pointerIndex;
            stringBuilder.append(1);
        }
    }

    public static void getPointerUp() {
        if (pointerIndex - 1 >= 0) {
            --pointerIndex;
            stringBuilder.append(2);
        }
    }

    public static void getCurrentChannelDown(String[] channels) {
        if (pointerIndex >= channels.length - 1) {
            return;
        }

        swap(channels, pointerIndex, pointerIndex + 1);
        ++pointerIndex;
        stringBuilder.append(3);
    }

    public static void getCurrentChannelUp(String[] channels) {
        if (pointerIndex == 0) {
            return;
        }

        swap(channels, pointerIndex - 1, pointerIndex);
        --pointerIndex;
        stringBuilder.append(4);
    }

    private static void swap(String[] channels, int leftIdx, int rightIdx) {
        String temp = channels[leftIdx];
        channels[leftIdx] = channels[rightIdx];
        channels[rightIdx] = temp;
    }
}