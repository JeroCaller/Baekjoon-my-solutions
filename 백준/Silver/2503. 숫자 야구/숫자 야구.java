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
        final int N = Integer.parseInt(br.readLine());
        final List<Hint> hints = new ArrayList<>();
        String[] input;
        int answer = 0;

        for (int i = 0; i < N; ++i) {
            input = br.readLine().split(" ");
            hints.add(new Hint(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                if (j == i) {
                    continue;
                }

                kloop : for (int k = 1; k <= 9; ++k) {
                    if (k == j || k == i) {
                        continue;
                    }

                    int[] candidate = {i, j, k};

                    for (Hint hint : hints) {
                        Hint candidateInfo = new Hint("", 0, 0);

                        for (int l = 0; l < candidate.length; ++l) {
                            for (int m = 0; m < hint.getNumbersInStr().length(); ++m) {
                                if (candidate[l] == hint.getNumbersInStr().charAt(m) - '0') {
                                    if (l == m) {
                                        candidateInfo.addOneToStrikes();
                                    } else {
                                        candidateInfo.addOneToBalls();
                                    }

                                    break;
                                }
                            }
                        }

                        if (!hint.equals(candidateInfo)) {
                            continue kloop;
                        }
                    }

                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));
    }
}

class Hint {
    private String numbersInStr;
    private int strikes;
    private int balls;

    public Hint(String numbersInStr, int strikes, int balls) {
        this.numbersInStr = numbersInStr;
        this.strikes = strikes;
        this.balls = balls;
    }

    public String getNumbersInStr() {
        return numbersInStr;
    }

    public int getStrikes() {
        return strikes;
    }

    public void addOneToStrikes() {
        ++strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void addOneToBalls() {
        ++balls;
    }

    @Override
    public boolean equals(Object obj) {
        Hint hints;

        if (obj instanceof Hint) {
            hints = (Hint) obj;
        } else {
            return false;
        }

        return this.getStrikes() == hints.getStrikes() && this.getBalls() == hints.getBalls();
    }
}