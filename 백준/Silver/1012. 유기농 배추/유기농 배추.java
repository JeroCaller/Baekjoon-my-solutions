import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

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
        final Map<Position, List<Position>> adjacentMap = new HashMap<>();
        final Set<Position> visitedSet = new HashSet<>();
        final Stack<Position> stack = new Stack<>();
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            String[] conditions = br.readLine().split(" ");
            final int M = Integer.parseInt(conditions[0]);
            final int N = Integer.parseInt(conditions[1]);
            final int K = Integer.parseInt(conditions[2]);
            int count = 0;

            for (int j = 0; j < K; ++j) {
                String[] input = br.readLine().split(" ");
                Position position = new Position(
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1])
                );
                adjacentMap.put(position, new ArrayList<>());
            }

            for (Position keyPos : adjacentMap.keySet()) {
                List<Position> adjPosList = new ArrayList<>();
                adjPosList.add(new Position(keyPos.getX() + 1, keyPos.getY()));
                adjPosList.add(new Position(keyPos.getX() - 1, keyPos.getY()));
                adjPosList.add(new Position(keyPos.getX(), keyPos.getY() + 1));
                adjPosList.add(new Position(keyPos.getX(), keyPos.getY() - 1));

                for (Position adjPos : adjPosList) {
                    if (adjacentMap.containsKey(adjPos)) {
                        adjacentMap.get(adjPos).add(keyPos);
                    }
                }
            }

            for (Position keyPos : adjacentMap.keySet()) {
                if (visitedSet.contains(keyPos)) {
                    continue;
                }

                stack.push(keyPos);

                while (!stack.isEmpty()) {
                    Position currentPos = stack.pop();

                    for (Position adjPos : adjacentMap.get(currentPos)) {
                        if (visitedSet.contains(adjPos)) {
                            continue;
                        }

                        stack.push(adjPos);
                    }

                    visitedSet.add(currentPos);
                }

                ++count;
            }

            bw.write(String.valueOf(count));
            bw.newLine();

            adjacentMap.clear();
            visitedSet.clear();
        }
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        Position otherPos = (Position) obj;
        return (this.getX() == otherPos.getX() && this.getY() == otherPos.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
