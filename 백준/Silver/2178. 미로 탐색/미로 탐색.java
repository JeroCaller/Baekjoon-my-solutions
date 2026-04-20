import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, m;
    private static boolean[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        map = new boolean[n][m];
        visited = new int[n][m];
        String inputLine;

        for (int i = 0; i < n; ++i) {
            inputLine = br.readLine();

            for (int j = 0; j < m; ++j) {
                map[i][j] = inputLine.charAt(j) == '1';
            }
        }

        bw.write(String.valueOf(search()));
    }

    private static int search() {
        Position targetPos = new Position(n - 1, m - 1);
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Position currentPos = queue.poll();

            for (Position nextPos : getAdjacentPositions(currentPos)) {
                if (currentPos.equals(targetPos)) {
                    return visited[currentPos.getR()][currentPos.getC()];
                }

                if (visited[nextPos.getR()][nextPos.getC()] != 0) {
                    continue;
                }

                queue.offer(nextPos);
                visited[nextPos.getR()][nextPos.getC()] =
                    visited[currentPos.getR()][currentPos.getC()] + 1;
            }
        }

        return 0;
    }

    private static List<Position> getAdjacentPositions(Position currentPos) {
        List<Position> adjacentPositions = new ArrayList<>();
        List<Position> candidates = new ArrayList<>();
        candidates.add(new Position(currentPos.getR() - 1, currentPos.getC()));
        candidates.add(new Position(currentPos.getR() + 1, currentPos.getC()));
        candidates.add(new Position(currentPos.getR(), currentPos.getC() - 1));
        candidates.add(new Position(currentPos.getR(), currentPos.getC() + 1));

        for (Position candidate : candidates) {
            if (candidate.getR() < 0 || candidate.getR() >= n ||
                candidate.getC() < 0 || candidate.getC() >= m) {
                continue;
            }

            if (!map[candidate.getR()][candidate.getC()]) {
                continue;
            }

            adjacentPositions.add(candidate);
        }

        return adjacentPositions;
    }
}

class Position {
    private int r, c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() { return r; }
    public int getC() { return c; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Position other = (Position) obj;
        return (this.getR() == other.getR() && this.getC() == other.getC());
    }
}