import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    private static int n, tempCount;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static final List<Integer> numOfHouses = new ArrayList<>();
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        String input = br.readLine();
        n = Integer.parseInt(input);
        map = new boolean[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            input = br.readLine();

            for (int j = 0; j < n; ++j) {
                map[i][j] = input.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!map[i][j] || visited[i][j]) {
                    continue;
                }

                dfs(new Position(i, j));
                numOfHouses.add(tempCount);
                tempCount = 0;
            }
        }

        Collections.sort(numOfHouses);
        bw.write(String.valueOf(numOfHouses.size()));
        bw.newLine();

        for (int houses : numOfHouses) {
            bw.write(String.valueOf(houses));
            bw.newLine();
        }
    }

    private static void dfs(Position currentPos) {
        if (visited[currentPos.getR()][currentPos.getC()]) {
            return;
        }

        visited[currentPos.getR()][currentPos.getC()] = true;
        tempCount++;

        for (Position nextPos : getAdjacentPositions(currentPos)) {
            dfs(nextPos);
        }
    }

    private static List<Position> getAdjacentPositions(Position currentPos) {
        List<Position> adjacentPositions = new ArrayList<>();

        for (int i = 0; i < dr.length; ++i) {
            int nextR = currentPos.getR() + dr[i];
            int nextC = currentPos.getC() + dc[i];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) {
                continue;
            }

            if (!map[nextR][nextC] || visited[nextR][nextC]) {
                continue;
            }

            adjacentPositions.add(new Position(nextR, nextC));
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
}