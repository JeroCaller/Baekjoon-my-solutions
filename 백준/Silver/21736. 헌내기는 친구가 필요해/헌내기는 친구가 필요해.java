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
    private static char[][] campus;
    private static boolean[][] visited;
    private static Position startPoint;

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
        campus = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            String row = br.readLine();

            for (int j = 0; j < m; ++j) {
                campus[i][j] = row.charAt(j);

                switch (campus[i][j]) {
                    case 'I':
                        startPoint = new Position(i, j);
                        break;
                    case 'X':
                        visited[i][j] = true;
                        break;
                }
            }
        }

        int answer = search();

        if (answer != 0) {
            bw.write(String.valueOf(answer));
        } else {
            bw.write("TT");
        }
    }

    private static int search() {
        int count = 0;
        final Queue<Position> queue = new ArrayDeque<>();
        queue.offer(startPoint);
        visited[startPoint.getR()][startPoint.getC()] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            List<Position> adjacents = new ArrayList<>();
            adjacents.add(new Position(position.getR() + 1, position.getC()));
            adjacents.add(new Position(position.getR(), position.getC() + 1));
            adjacents.add(new Position(position.getR() - 1, position.getC()));
            adjacents.add(new Position(position.getR(), position.getC() - 1));

            for (Position nextPos : adjacents) {
                if ((nextPos.getR() < 0 || nextPos.getR() >= n) ||
                    (nextPos.getC() < 0 || nextPos.getC() >= m) ||
                    visited[nextPos.getR()][nextPos.getC()]
                ) {
                    continue;
                }

                visited[nextPos.getR()][nextPos.getC()] = true;
                queue.offer(nextPos);

                if (campus[nextPos.getR()][nextPos.getC()] == 'P') {
                    count++;
                }
            }
        }

        return count;
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
