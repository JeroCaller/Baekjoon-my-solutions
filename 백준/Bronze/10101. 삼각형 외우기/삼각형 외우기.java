import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        List<Integer> angles = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            angles.add(Integer.parseInt(br.readLine()));
        }

        TriangleTypeDecider decider = new TriangleTypeDecider(angles);
        String result = decider.getType();
        bw.write(result);

    }

}

class TriangleTypeDecider {

    private final List<Integer> targetAngles;
    private final Set<Integer> angleSet;

    public TriangleTypeDecider(List<Integer> targetAngles) {
        this.targetAngles = targetAngles;
        this.angleSet = new HashSet<>(this.targetAngles);
    }

    public String getType() {
        if (isError()) return "Error";
        if (isEquilateral()) return "Equilateral";
        if (isIsosceles()) return "Isosceles";
        if (isScalene()) return "Scalene";
        return null;
    }

    private boolean isError() {
        int totalAngle = 0;
        for (Integer angle : targetAngles) {
            totalAngle += angle;
        }

        return totalAngle != 180;
    }

    private boolean isEquilateral() {
        return angleSet.size() == 1 && angleSet.toArray()[0].equals(60);
    }

    private boolean isIsosceles() {
        return angleSet.size() == 2;
    }

    private boolean isScalene() {
        return angleSet.size() == 3;
    }

}