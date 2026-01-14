import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

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
        while (true) {
            String[] conditions = br.readLine().split(" ");

            if (conditions.length == 2 && conditions[0].equals("0") && conditions[1].equals("0")) {
                break;
            }

            int w = Integer.parseInt(conditions[0]);
            int h = Integer.parseInt(conditions[1]);
            boolean[][] map = new boolean[h][w];
            boolean[][] hasVisited = new boolean[h][w];
            Queue<Position> filledSquarePos = new ArrayDeque<>();

            for (int y = 0; y < h; ++y) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int x = 0; x < w; ++x) {
                    int num = Integer.parseInt(st.nextToken());
                    map[y][x] = num == 1;

                    if (num == 1) {
                        filledSquarePos.offer(new Position(x, y));
                    }
                }
            }

            int count = 0;

            while (!filledSquarePos.isEmpty()) {
                if(dfs(map, hasVisited, filledSquarePos.poll())) {
                    ++count;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
    }

    private static boolean dfs(boolean[][] map, boolean[][] hasVisited, Position startPos) {
        if (hasVisited[startPos.getY()][startPos.getX()]) return false;
        Stack<Position> stack = new Stack<>();
        stack.push(startPos);

        while (!stack.isEmpty()) {
            Position currentPos = stack.pop();
            hasVisited[currentPos.getY()][currentPos.getX()] = true;

            for (int y = currentPos.getY() - 1; y <= currentPos.getY() + 1; ++y) {
                if (y < 0 || y >= map.length) continue;

                for (int x = currentPos.getX() - 1; x <= currentPos.getX() + 1; ++x) {
                    if (x < 0 || x >= map[0].length) continue;
                    if (map[y][x] && !hasVisited[y][x]) {
                        stack.push(new Position(x, y));
                    }
                }
            }
        }

        return true;
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}