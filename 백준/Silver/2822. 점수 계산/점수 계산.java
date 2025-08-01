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
        List<Quiz> highest = new ArrayList<>();

        for (int i = 1; i <= 8; ++i) {
            int score = Integer.parseInt(br.readLine());

            if (highest.size() < 5) {
                highest.add(new Quiz(i, score));
                highest.sort((q1, q2) -> q2.getScore() - q1.getScore());
            } else {
                for (int j = 0; j < highest.size(); ++j) {
                    if (highest.get(j).getScore() < score) {
                        highest.add(j, new Quiz(i, score));
                        break;
                    }
                }

                highest = highest.subList(0, 5);
            }

            //bw.write(highest.toString());
            //bw.newLine();
        }

        highest.sort((q1, q2) -> q1.getQuizNumber() - q2.getQuizNumber());

        StringBuilder stringBuilder = new StringBuilder();
        int total = 0;

        for (Quiz quiz : highest) {
            total += quiz.getScore();
            stringBuilder.append(quiz.getQuizNumber()).append(" ");
        }

        bw.write(String.valueOf(total));
        bw.newLine();
        bw.write(stringBuilder.toString());
    }
}

class Quiz {
    private int quizNumber;
    private int score;

    public Quiz(int quizNumber, int score) {
        this.quizNumber = quizNumber;
        this.score = score;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%d : %d", quizNumber, score);
    }
}