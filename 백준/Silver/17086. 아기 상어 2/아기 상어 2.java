import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new int[n][m];
        List<Position> startingPoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; ++j) {
                map[i][j] = st.nextToken().equals("1");

                if (map[i][j]) {
                    startingPoints.add(new Position(i, j));
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            Arrays.fill(visited[i], -1);
        }

        search(startingPoints);

        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                answer = Math.max(answer, visited[i][j]);
            }
        }

        bw.write(String.valueOf(answer));
    }

    private static void search(List<Position> startingPoints) {
        Queue<Position> queue = new ArrayDeque<>();

        for (Position pos : startingPoints) {
            queue.offer(pos);
            visited[pos.getR()][pos.getC()] = 0;
        }

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (Position nextPos : getAdjacents(pos)) {
                if (visited[nextPos.getR()][nextPos.getC()] != -1) {
                    continue;
                }

                queue.offer(nextPos);
                visited[nextPos.getR()][nextPos.getC()] = visited[pos.getR()][pos.getC()] + 1;
            }
        }
    }

    private static List<Position> getAdjacents(Position currentPos) {
        List<Position> adjacentPos = new ArrayList<>();

        for (int r = currentPos.getR() - 1; r <= currentPos.getR() + 1; ++r) {
            for (int c = currentPos.getC() - 1; c <= currentPos.getC() + 1; ++c) {
                if (r == currentPos.getR() && c == currentPos.getC()) {
                    continue;
                }

                try {
                    boolean b = map[r][c];
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

                adjacentPos.add(new Position(r, c));
            }
        }

        return adjacentPos;
    }
}

class Position {
    private int r;
    private int c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() { return r; }
    public int getC() { return c; }
}