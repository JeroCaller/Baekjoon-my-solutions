import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int maxHeight = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; ++j) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height);
                map[i][j] = height;
            }
        }

        GraphSearch graphSearch = new GraphSearch(n, map);
        int answer = 0;

        for (int i = 0; i <= maxHeight; ++i) {
            int numOfAreas = graphSearch.searchSafeAreas(i);
            answer = Math.max(answer, numOfAreas);
        }

        bw.write(String.valueOf(answer));
    }
}

class GraphSearch {
    private int size;
    private final boolean[][] visited;
    private final int[][] map;
    private final Stack<Position> stack = new Stack<>();

    public GraphSearch(int size, int[][] map) {
        this.size = size;
        this.map = map;
        this.visited = new boolean[this.size][this.size];
    }

    public int searchSafeAreas(int height) {
        resetVisited();
        stack.clear();

        int numOfSafeAreas = 0;

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (visited[i][j] || map[i][j] - height <= 0) {
                    continue;
                }

                search(new Position(i, j), height);
                numOfSafeAreas++;
            }
        }

        return numOfSafeAreas;
    }

    private void search(Position startPos, int height) {
        stack.push(startPos);
        visited[startPos.getR()][startPos.getC()] = true;

        while (!stack.isEmpty()) {
            Position pos = stack.pop();

            for (Position nextPos : getAdjacentNodes(pos)) {
                if (visited[nextPos.getR()][nextPos.getC()] ||
                    map[nextPos.getR()][nextPos.getC()] - height <= 0) {
                    continue;
                }

                stack.push(nextPos);
                visited[nextPos.getR()][nextPos.getC()] = true;
            }
        }
    }

    private List<Position> getAdjacentNodes(Position pos) {
        List<Position> adjacentPositions = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; ++i) {
            int nextR = pos.getR() + dr[i];
            int nextC = pos.getC() + dc[i];

            if (nextR < 0 || nextR >= size || nextC < 0 || nextC >= size) {
                continue;
            }

            adjacentPositions.add(new Position(nextR, nextC));
        }

        return adjacentPositions;
    }

    private void resetVisited() {
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
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
}