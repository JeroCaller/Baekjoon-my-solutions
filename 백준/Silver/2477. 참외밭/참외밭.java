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
    
    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        final int K = Integer.parseInt(br.readLine());
        final List<Line> queue = new ArrayList<>();

        for (int i = 0; i < 6; ++i) {
            String[] inputs = br.readLine().split(" ");
            queue.add(new Line(
                Integer.parseInt(inputs[0]),
                Integer.parseInt(inputs[1])
            ));
        }

        int totalArea = 1;
        final Line[] firstLineMemo = new Line[2];
        final Line[] secondLineMemo = new Line[2];

        while (true) {
            boolean isEqual = true;

            for (int i = 0; i < 2; ++i) {
                firstLineMemo[i] = queue.get(i);
            }

            for (int i = 0; i < 2; ++i) {
                secondLineMemo[i] = queue.get(i + 2);
            }

            for (int i = 0; i < 2; ++i) {
                if (!firstLineMemo[i].equals(secondLineMemo[i])) {
                    isEqual = false;
                }
            }

            if (isEqual) {
                for (int i = 4; i < 6; ++i) {
                    totalArea *= queue.get(i).getLength();
                }

                totalArea -= firstLineMemo[1].getLength() * secondLineMemo[0].getLength();
                break;
            } else {
                queue.remove(0);
                queue.add(firstLineMemo[0]);
            }
        }

        bw.write(String.valueOf(K * totalArea));
    }
}

class Line {
    private int direction;
    private int length;

    public Line(int direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public int getDirection() { return direction; }
    public int getLength() { return length; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Line other;

        if (obj instanceof Line) {
            other = (Line) obj;
        } else {
            return false;
        }

        return this.getDirection() == other.getDirection();
    }
}